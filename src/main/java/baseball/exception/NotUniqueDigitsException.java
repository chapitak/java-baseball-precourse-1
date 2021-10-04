package baseball.exception;

public class NotUniqueDigitsException extends IllegalArgumentException {
    public NotUniqueDigitsException(String message) {
        super(message);
    }
}
