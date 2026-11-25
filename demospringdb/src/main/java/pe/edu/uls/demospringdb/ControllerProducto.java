package pe.edu.uls.demospringdb;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController 
public class ControllerProducto {

    @Autowired 
    ServiceProducto service;

    @GetMapping("/productos")
    public List<Producto> consultarProductos() {
        return service.consultarTodos();
    }
    
    @PostMapping("/producto/nuevo")
    public Producto registrarProducto(@RequestBody Producto nuevo) {
        return service.registrar(nuevo);
    }
    

}
