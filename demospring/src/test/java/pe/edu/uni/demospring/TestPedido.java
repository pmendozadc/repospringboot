package pe.edu.uni.demospring;

import pe.edu.uni.demospring.cu.registrarpedido.request.RequestPedido;
import pe.edu.uni.demospring.cu.registrarpedido.request.RequestPedido.RequestPedidoItem;
import pe.edu.uni.demospring.cu.registrarpedido.response.ResponsePedido;
import pe.edu.uni.demospring.dominio.entity.Producto;
import pe.edu.uni.demospring.dominio.repository.RepoProducto;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import tools.jackson.databind.ObjectMapper;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import org.springframework.boot.test.web.client.TestRestTemplate;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class TestPedido {

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private RepoProducto repoProducto;

    @Test 
    @DisplayName("Debe guardar dos pedidos concurrentes reales descontando el stock")
    void testRegistrarPedidoConcurrenteReal() throws Exception {
        int productoId = 1004;
        Producto producto = repoProducto.findById(productoId).get();
        int stockantes = producto.getStock();
        int cantidad = 2;
        int numeroHilos = 2;

        List<RequestPedidoItem> items = List.of(
                new RequestPedidoItem(productoId, cantidad, 1200.00)
        );
        RequestPedido pedido = new RequestPedido(items);

        CountDownLatch latchInicio = new CountDownLatch(1);
        CountDownLatch latchFin = new CountDownLatch(numeroHilos);
        ExecutorService executorService = Executors.newFixedThreadPool(numeroHilos);

        for (int i = 0; i < numeroHilos; i++) {
            executorService.submit(() -> {
                try {
                    latchInicio.await();
                    // Hace una petición HTTP real al servidor embebido
                    ResponseEntity<ResponsePedido> response = restTemplate.postForEntity(
                            "/pedido/nuevo", pedido, ResponsePedido.class
                    );
                    assertThat(response.getStatusCode().is2xxSuccessful()).isTrue();
                } catch (Exception e) {
                    throw new RuntimeException(e);
                } finally {
                    latchFin.countDown();
                }
            });
        }

        latchInicio.countDown(); // ¡Disparar al mismo tiempo!
        latchFin.await(5, TimeUnit.SECONDS);
        executorService.shutdown();
        
        // Validar stock final con concurrencia real en BD
        producto = repoProducto.findById(productoId).get();
        assertThat(producto.getStock()).isEqualTo(stockantes - (cantidad * numeroHilos));
    }
}