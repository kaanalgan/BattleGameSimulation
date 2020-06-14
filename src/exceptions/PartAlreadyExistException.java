package exceptions;

public class PartAlreadyExistException extends Exception {
    public PartAlreadyExistException(String errorMessage) {
        super(errorMessage);
    }
}
