package exception;

public class NoSuchEmployeeException extends IllegalArgumentException {

    public NoSuchEmployeeException(String message){
        super(message);
    }
}
