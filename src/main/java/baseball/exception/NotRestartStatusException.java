package baseball.exception;

public class NotRestartStatusException extends IllegalArgumentException {
    public NotRestartStatusException(String message) {
        super(message);
    }
}
