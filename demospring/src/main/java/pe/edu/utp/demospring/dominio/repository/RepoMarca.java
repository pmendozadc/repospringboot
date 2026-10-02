package pe.edu.utp.demospring.dominio.repository;

import pe.edu.utp.demospring.dominio.entity.Marca;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepoMarca extends JpaRepository<Marca, Integer> {

}
