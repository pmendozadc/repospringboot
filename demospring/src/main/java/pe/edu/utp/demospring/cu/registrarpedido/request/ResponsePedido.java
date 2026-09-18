package pe.edu.utp.demospring.cu.registrarpedido.request;

import java.util.List;

/**
 * ResponsePedido
 */
public record ResponsePedido(int idPedido, List<ResponsePedidoItem> items) {

    public record ResponsePedidoItem(String nombre, int cantidad) {}
}
