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

    private final RepoProducto repoProducto;

    public ControllerProductos(ServiceProductos serviceProductos, MapperProducto mapperProducto, RepoProducto repoProducto) {
        this.serviceProductos = serviceProductos;
        this.mapperProducto = mapperProducto;
        this.repoProducto=repoProducto;
    }



    @GetMapping("/producto/buscarPorNombre/{nombre}")
    public List<DTOProductoResponse> buscarPorNombre(@PathVariable(name = "nombre") String nombre) {
        return serviceProductos.consultarProductosPorNombre(nombre);
    }

    @GetMapping("/productomarca")
    public Producto registrarProductoMarca() {
        Producto pro = new Producto();
        pro.setDescripcion("ejemplo");
        pro.setNombre("ejemplo");
        pro.setPrecio(100);
        Marca marca = new Marca();
        marca.setNombre("ABC");
        pro.setMarca(marca);
        repoProducto.save(pro);
        return pro;
    }
    
}
