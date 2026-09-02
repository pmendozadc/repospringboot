package pe.edu.utp.demospring;

import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MapperProducto {

    Producto toDominio(RequestProducto request);

    ResponseProducto toResponse(Producto pro);
}