package pe.edu.utp.demospring.cu.registrarpedido;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import pe.edu.utp.demospring.cu.registrarpedido.exception.StockInsuficienteException;
import pe.edu.utp.demospring.cu.registrarpedido.request.RequestPedido;
import pe.edu.utp.demospring.cu.registrarpedido.request.RequestPedido.RequestPedidoItem;
import pe.edu.utp.demospring.cu.registrarpedido.response.ResponsePedido;
import pe.edu.utp.demospring.dominio.entity.Pedido;
import pe.edu.utp.demospring.dominio.entity.Producto;
import pe.edu.utp.demospring.dominio.repository.RepoPedido;
import pe.edu.utp.demospring.dominio.repository.RepoProducto;

@Service 
public class ServiceRegistrarPedido {

    RepoProducto repoProducto;

    RepoPedido repoPedido;

    public ServiceRegistrarPedido(RepoProducto repoProducto, RepoPedido repoPedido) {
        this.repoProducto = repoProducto;
        this.repoPedido = repoPedido;
    }

    @Transactional 
    public ResponsePedido registrarPedido(RequestPedido pedido) {
        Pedido p = new Pedido();    
        List<ResponsePedido.ResponsePedidoItem> lst = new ArrayList<ResponsePedido.ResponsePedidoItem>();
        for (RequestPedidoItem item : pedido.items()) {
            Producto producto = repoProducto.findById(item.idProducto()).get();
            if (producto.getStock() < item.cantidad()) {
                throw new StockInsuficienteException(
                        "Stock insuficiente para el producto: " + producto.getNombre() + 
                        ". Disponible: " + producto.getStock() + ", Solicitado: " + item.cantidad()
                );
            }
            p.agregarItem(producto, item.cantidad(), item.precioUnitario());
            lst.add(new ResponsePedido.ResponsePedidoItem(producto.getNombre(), item.cantidad()));
            producto.setStock(producto.getStock() - item.cantidad());
            repoProducto.save(producto);
        }
        repoPedido.save(p);
        ResponsePedido respPedido = new ResponsePedido(p.getId(), lst);
        return respPedido;
    }

    public List<ResponsePedido> buscarPedidoPorProductoId(int productoId) {
        List<Pedido> lstPedido = repoPedido.buscarPorProductoId(productoId);
        return lstPedido.stream().map(p->new ResponsePedido(p.getId(), p.getItems().stream().map(i->new ResponsePedido.ResponsePedidoItem(i.getProducto().getNombre(), i.getCantidad())).toList())).toList();
    }

    public List<ResponsePedido> buscarPedidoPorProductoNombre(String productoNombre) {
        List<Pedido> lstPedido = repoPedido.buscarPorProductoNombre("%"+productoNombre+"%");
        return lstPedido.stream().map(p->new ResponsePedido(p.getId(), p.getItems().stream().map(i->new ResponsePedido.ResponsePedidoItem(i.getProducto().getNombre(), i.getCantidad())).toList())).toList();
    }
}
