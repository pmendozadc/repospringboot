package pe.edu.utp.demospring;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
public class ControllerProductos {
    
    private final ServiceProductos serviceProductos;

    private final MapperProducto mapperProducto; 

    

    public ControllerProductos(ServiceProductos serviceProductos, MapperProducto mapperProducto) {
        this.serviceProductos = serviceProductos;
        this.mapperProducto = mapperProducto;
    }



    @GetMapping("/producto/buscarPorNombre/{nombre}")
    public List<DTOProductoResponse> buscarPorNombre(@PathVariable(name = "nombre") String nombre) {
        return serviceProductos.consultarProductosPorNombre(nombre);
    }

    @PostMapping("/producto/nuevo")
    public ResponseProducto registrar(@Valid @RequestBody RequestProducto nuevo) {
        Producto pro = mapperProducto.toDominio(nuevo);
        ResponseProducto resp = mapperProducto.toResponse(serviceProductos.registrarProducto(pro));
        return resp;
    }
    
}
