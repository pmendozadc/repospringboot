package pe.edu.uls.demospringdb;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service 
public class ServiceProducto {

    @Autowired 
    RepositoryProducto repoProducto;

    public Producto registrar(Producto nuevo) {
        return repoProducto.save(nuevo);
    }

    public List<Producto> consultarTodos() {
        return repoProducto.findAll();
    }
}
