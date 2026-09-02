package pe.edu.utp.demospring;

import org.mapstruct.Mapper;

@Mapper
public interface MapperProducto {

    Producto toDominio(RequestProducto request);

    ResponseProducto toResponse(Producto pro);
}