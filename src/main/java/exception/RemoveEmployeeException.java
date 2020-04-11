package exception;

public class RemoveEmployeeException extends Exception {
    public RemoveEmployeeException() {
    }

    public RemoveEmployeeException(String message){
        super(message);
    }
}
