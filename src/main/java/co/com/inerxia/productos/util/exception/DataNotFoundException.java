package co.com.inerxia.productos.util.exception;

public class DataNotFoundException extends GeneralRuntimeException{

    private static final long serialVersionUID = 1L;

    public DataNotFoundException(String mensaje){
        super(mensaje);
    }

}
