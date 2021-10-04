package baseball.exception;

public class NotThreeDigitsException extends IllegalArgumentException {
    public NotThreeDigitsException(String message) {
        super(message);
    }
}
