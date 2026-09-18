package pe.edu.utp.demospring.cu.registrarpedido.request;

import java.util.List;

public record RequestPedido (List<RequestPedidoItem> items) {

    public record RequestPedidoItem(int idProducto, int cantidad, Double precio) {

    }
}
