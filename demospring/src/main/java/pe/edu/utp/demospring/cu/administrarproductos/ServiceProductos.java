package pe.edu.utp.demospring.cu.administrarproductos;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import pe.edu.utp.demospring.cu.administrarproductos.exception.ProductoNoEncontradoException;
import pe.edu.utp.demospring.cu.administrarproductos.response.ResponseProducto;
import pe.edu.utp.demospring.dominio.entity.Producto;

@Service
public class ServiceProductos {

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

    public Producto registrarProducto(Producto nuevo) {
        return nuevo;
    }
}
