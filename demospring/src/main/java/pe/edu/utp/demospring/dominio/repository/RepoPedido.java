package pe.edu.utp.demospring.dominio.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import pe.edu.utp.demospring.dominio.entity.Pedido;

public interface RepoPedido extends JpaRepository<Pedido, Integer> {

    @Query("""
        SELECT p
        FROM Pedido p
        JOIN p.items item
        JOIN item.producto producto
        WHERE producto.id = :productoId
    """)
    List<Pedido> buscarPorProductoId(int productoId);

    @Query("""
        SELECT p
        FROM Pedido p
        JOIN p.items item
        JOIN item.producto producto
        WHERE producto.nombre LIKE :productoNombre
    """)
    List<Pedido> buscarPorProductoNombre(String productoNombre);
}
