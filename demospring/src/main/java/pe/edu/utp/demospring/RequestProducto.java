package pe.edu.utp.demospring;

import java.time.LocalDate;

import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;

public record RequestProducto(@NotNull String nombre, @NotBlank @Pattern(
        regexp = "^[a-zA-Z0-9]+$",
        message = "La descripcion solo puede contener letras y numeros"
    ) String descripcion, @DecimalMin(value="0.9") @DecimalMax(value="9999.99") double precio, @Min(value = 10, message = "El stock minimo es 10")
    @Max(value = 1000, message = "El stock maximo es 1000") int stock, @Past LocalDate fechaOrden, @Future LocalDate fechaVencimiento) {

}
