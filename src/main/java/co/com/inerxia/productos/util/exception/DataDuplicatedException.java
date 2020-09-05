package co.com.inerxia.productos.util.exception;

public class DataDuplicatedException extends GeneralRuntimeException{

    private static  final long serialVersionUID = 1L;

    public DataDuplicatedException(String mensaje){
        super(mensaje);
    }
}
