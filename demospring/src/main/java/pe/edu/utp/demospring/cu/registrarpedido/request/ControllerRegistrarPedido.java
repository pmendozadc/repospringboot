package pe.edu.utp.demospring.cu.registrarpedido.request;

import org.springframework.web.bind.annotation.RestController;

import pe.edu.utp.demospring.dominio.entity.Pedido;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController 
public class ControllerRegistrarPedido {

    ServiceRegistrarPedido serviceRegistrarPedido;

    public ControllerRegistrarPedido(ServiceRegistrarPedido serviceRegistrarPedido) {
        this.serviceRegistrarPedido = serviceRegistrarPedido;
    }

    @PostMapping("/pedido/nuevo")
    public ResponsePedido guardarPedido(@RequestBody RequestPedido pedido) {
        return serviceRegistrarPedido.registrarPedido(pedido);
    }
    
}
