package pe.edu.utp.demospring;

public class ProductoNoEncontradoException extends RuntimeException {

    public ProductoNoEncontradoException(String msg) {
        super(msg);
    }
}
