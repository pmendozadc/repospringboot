package pe.edu.uni.demospring.cu.administrarparametros;

import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController 
public class ControllerParametros {

    private static Map<String, Object> params = new HashMap<String, Object>();

    static {
        params.put("IGV", 0.18);
    }

    @GetMapping("/param/{id}")
    public Map<String, Object> consultarParametro(@PathVariable(name = "id") String id) {
        Map<String, Object> map = new HashMap<String, Object>();
        if (params.get(id)!= null) {
            map.put("valor", params.get(id));
        }
        map.put("id", id);
        return map;
    }

    @PostMapping("path")
    public Map<String, Object> registrarParametro(@RequestBody Map<String, Object> nuevo) {
        params.put(nuevo.get("id").toString(), nuevo.get("valor"));
        return nuevo;
    }
    
}
