package pe.edu.utp.demospring;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RepoProducto extends JpaRepository<Producto, Integer> {

}
