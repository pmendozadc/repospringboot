package pe.edu.utp.demospring;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class ServiceProductos {

    public List<DTOProductoResponse> consultarProductosPorNombre(String nombre) {
        List<DTOProductoResponse> lst = new ArrayList<>();
        for (int i=1;i<=5;i++) {
            DTOProductoResponse dto = new DTOProductoResponse(i, nombre+" "+i, 1000+i);
            lst.add(dto);
        }
        return lst;
    }
}
