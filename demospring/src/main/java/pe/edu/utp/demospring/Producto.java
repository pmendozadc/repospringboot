package pe.edu.utp.demospring;

import java.time.LocalDate;

public record Producto(String nombre, String descripcion, double precio, int stock, LocalDate fechaOrden, LocalDate fechaVencimiento) {

}