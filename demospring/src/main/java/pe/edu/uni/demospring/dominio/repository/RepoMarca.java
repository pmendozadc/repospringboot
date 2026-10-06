package pe.edu.uni.demospring.dominio.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pe.edu.uni.demospring.dominio.entity.Marca;

public interface RepoMarca extends JpaRepository<Marca, Integer> {

}
