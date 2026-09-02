package pe.edu.utp.demospring;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerProductos {

    @Autowired
    private ServiceProductos serviceProductos;

    @GetMapping("/producto/buscarPorNombre/{nombre}")
    public List<DTOProductoResponse> buscarPorNombre(@PathVariable(name = "nombre") String nombre) {
        return serviceProductos.consultarProductosPorNombre(nombre);
    }
}
