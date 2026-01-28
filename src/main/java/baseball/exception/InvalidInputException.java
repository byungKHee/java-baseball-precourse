package baseball.exception;

public class InvalidInputException extends RuntimeException{
    public InvalidInputException(String message) {
        super("[ERROR] " + message);
    }
}
