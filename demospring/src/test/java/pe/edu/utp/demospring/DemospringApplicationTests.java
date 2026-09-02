package pe.edu.utp.demospring;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.net.URI;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@SpringBootTest
@AutoConfigureMockMvc
class DemospringApplicationTests {

   @Autowired  
   MockMvc mockMvc;

   @Test  
   public void testSumar() throws Exception {
		System.out.println("Ejecutando test sumar");
	  URI uri = new URI("/sumar?op1=2&op2=3");
      MockHttpServletRequestBuilder req =       
          MockMvcRequestBuilders.get(uri).accept(MediaType.APPLICATION_JSON);
      MvcResult result = mockMvc.perform(req).andReturn();
      assertEquals(HttpStatus.OK.value(), result.getResponse().getStatus());
      assertEquals("5", result.getResponse().getContentAsString());
   }

   @Test  
   public void testBuscarProductoNoEncontrado() throws Exception {
		System.out.println("Ejecutando testBuscarProductoNoEncontrado");
	  URI uri = new URI("/producto/buscarPorNombre/aaa");
      MockHttpServletRequestBuilder req =       
          MockMvcRequestBuilders.get(uri).accept(MediaType.APPLICATION_JSON);
      MvcResult result = mockMvc.perform(req).andReturn();
      System.out.println("ESTADO: "+result.getResponse().getStatus());
      System.out.println("ESTADO HttpStatus.NOT_FOUND: "+HttpStatus.NOT_FOUND);
      assertEquals(HttpStatus.NOT_FOUND.value(), result.getResponse().getStatus());

   }

}
