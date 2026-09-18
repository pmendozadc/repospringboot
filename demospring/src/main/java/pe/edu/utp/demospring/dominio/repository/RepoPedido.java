package pe.edu.utp.demospring.dominio.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pe.edu.utp.demospring.dominio.entity.Pedido;

public interface RepoPedido extends JpaRepository<Pedido, Integer> {

}
