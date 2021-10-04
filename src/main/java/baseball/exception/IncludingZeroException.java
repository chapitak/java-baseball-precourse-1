package baseball.exception;

public class IncludingZeroException extends IllegalArgumentException {
    public IncludingZeroException(String message) {
        super(message);
    }
}
