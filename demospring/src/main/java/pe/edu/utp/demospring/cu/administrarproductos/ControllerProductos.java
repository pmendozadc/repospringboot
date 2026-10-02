package pe.edu.utp.demospring.cu.administrarproductos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import pe.edu.utp.demospring.cu.administrarproductos.mapper.MapperProducto;
import pe.edu.utp.demospring.cu.administrarproductos.request.RequestAjusteStock;
import pe.edu.utp.demospring.cu.administrarproductos.request.RequestProducto;
import pe.edu.utp.demospring.cu.administrarproductos.response.ResponseProducto;
import pe.edu.utp.demospring.dominio.entity.Marca;
import pe.edu.utp.demospring.dominio.entity.Producto;
import pe.edu.utp.demospring.dominio.repository.RepoProducto;


import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
public class ControllerProductos {
    
    private final ServiceProductos serviceProductos;

    private final RepoProducto repoProducto;

    public ControllerProductos(ServiceProductos serviceProductos, RepoProducto repoProducto) {
        this.serviceProductos = serviceProductos;
        this.repoProducto=repoProducto;
    }



    @GetMapping("/producto/buscarPorNombre/{nombre}")
    public List<ResponseProducto> buscarPorNombre(@PathVariable(name = "nombre") String nombre) {
        return serviceProductos.consultarProductosPorNombre(nombre);
    }

    @GetMapping("/producto/{id}")
    public Producto consultarProductoPorId(@PathVariable(name = "id") int id) {
        return serviceProductos.consultarProductosPorId(id);
    }

    @PostMapping("/producto/marca/{idmarca}/nuevo")
    public Producto registrarProductoMarca(@RequestBody RequestProducto requestProducto, @PathVariable(name = "idmarca") int idMarca) {
        return serviceProductos.registrarProducto(requestProducto, idMarca);
    }

    @PostMapping("/producto/stock/ajuste")
    public Producto ajustarProductoStock(@RequestBody RequestAjusteStock requestStock) {
        return serviceProductos.ajustarProductoStock(requestStock);
    }
    
}
