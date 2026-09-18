package pe.edu.utp.demospring.dominio.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pe.edu.utp.demospring.dominio.entity.Producto;

public interface RepoProducto extends JpaRepository<Producto, Integer> {

}
