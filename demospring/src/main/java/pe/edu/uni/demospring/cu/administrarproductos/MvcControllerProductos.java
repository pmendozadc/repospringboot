package pe.edu.uni.demospring.cu.administrarproductos;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import pe.edu.uni.demospring.dominio.entity.Producto;



@Controller 
public class MvcControllerProductos {

    private final ServiceProductos serviceProductos;

    public MvcControllerProductos(ServiceProductos serviceProductos) {
        this.serviceProductos = serviceProductos;
    }

    @GetMapping("/verproductos")
    public String verProductos(Model model) {
        List<Producto> productos = serviceProductos.consultarProductos();
        model.addAttribute("productos", productos);
        return "ejemplo";
    }
    

}
