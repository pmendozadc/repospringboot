package pe.edu.uni.demospring.cu.administrarproductos;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import pe.edu.uni.demospring.cu.administrarproductos.exception.ProductoNoEncontradoException;
import pe.edu.uni.demospring.cu.administrarproductos.request.RequestAjusteStock;
import pe.edu.uni.demospring.cu.administrarproductos.request.RequestProducto;
import pe.edu.uni.demospring.cu.administrarproductos.response.ResponseProducto;
import pe.edu.uni.demospring.dominio.entity.Marca;
import pe.edu.uni.demospring.dominio.entity.Producto;
import pe.edu.uni.demospring.dominio.repository.RepoMarca;
import pe.edu.uni.demospring.dominio.repository.RepoProducto;

@Service
public class ServiceProductos {

    RepoProducto repoProducto;
    RepoMarca repoMarca;

    public ServiceProductos(RepoProducto repoProducto, RepoMarca repoMarca) {
        this.repoProducto = repoProducto;
        this.repoMarca = repoMarca;
    }

    public Producto consultarProductosPorId(int id) {
        Optional<Producto> p = repoProducto.findById(id); 
        if (!p.isPresent()) {
            throw new ProductoNoEncontradoException("No existe tal producto");
        }
        return p.get();
    }

    public List<ResponseProducto> consultarProductosPorNombre(String nombre) {
        if (nombre.length() < 2 || nombre.equals("aaa")) {
            throw new ProductoNoEncontradoException("No existe tal producto");
        }
        List<ResponseProducto> lst = new ArrayList<>();
        for (int i=1;i<=5;i++) {
            ResponseProducto dto = new ResponseProducto(i, nombre+" "+i);
            lst.add(dto);
        }
        return lst;
    }

    @Transactional 
    public Producto registrarProducto(RequestProducto nuevo, int idMarca) {
        Optional<Marca> m = repoMarca.findById(idMarca);
        if (!m.isPresent()) {
            throw new RuntimeException("No existe la marca con ID "+idMarca);
        }
        Producto p = new Producto();
        p.setNombre(nuevo.nombre());
        p.setDescripcion(nuevo.descripcion());
        p.setPrecio(nuevo.precio());
        p.setStock(nuevo.stock());
        p.setMarca(m.get());
        repoProducto.save(p);
        return p;
    }

    @Transactional 
    public Producto ajustarProductoStock(RequestAjusteStock ajuste) {
        Optional<Producto> p = repoProducto.findById(ajuste.idProducto());
        if (!p.isPresent()) {
            throw new RuntimeException("No existe la marca con ID "+ajuste.idProducto());
        }
        Producto producto = p.get();
        producto.setStock(ajuste.stock());
        repoProducto.save(producto);
        return producto;
    }
}
