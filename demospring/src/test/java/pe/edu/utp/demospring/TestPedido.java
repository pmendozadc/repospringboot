package pe.edu.utp.demospring;

import pe.edu.uni.demospring.cu.registrarpedido.request.RequestPedido;
import pe.edu.uni.demospring.cu.registrarpedido.request.RequestPedido.RequestPedidoItem;
import pe.edu.uni.demospring.dominio.entity.Producto;
import pe.edu.uni.demospring.dominio.repository.RepoProducto;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import tools.jackson.databind.ObjectMapper;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.List;

@SpringBootTest
@AutoConfigureMockMvc 
class TestPedido {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private RepoProducto repoProducto;

    @AfterEach
    void tearDown() {
    }

    @Test
    @DisplayName("Debe guardar un pedido en BD y retornar 201 Created")
    void testRegistrarPedido() throws Exception {
        Producto producto = repoProducto.findAll().get(1004);
        int stockantes=producto.getStock();
        int cantidad=2;
        // 1. GIVEN (Dado)
        List<RequestPedidoItem> items = List.of(
                new RequestPedidoItem(1004, cantidad, 1200.00),
                new RequestPedidoItem(1005, cantidad, 800.00)
        );
        RequestPedido pedido = new RequestPedido(items);
        
        // 2. WHEN (Cuando realizamos la petición HTTP POST)
        mockMvc.perform(post("/pedido/nuevo")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(pedido)))
                
                // 3. THEN - Validación HTTP
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id").exists());

        // 4. THEN - Validación en la Base de Datos
        producto = repoProducto.findAll().get(1004);
        int stockdespues=producto.getStock();
        assertThat(stockdespues).isEqualTo(stockantes-cantidad);
    }
}