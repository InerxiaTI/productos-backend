package co.com.inerxia.productos.util.exception;

public class ObjectNoEncontradoException extends GeneralRuntimeException{

    private static  final long serialVersionUID = 1L;

    public ObjectNoEncontradoException(String mensaje){
        super(mensaje);
    }
}
