package baseball.domain;

import baseball.exception.NotRestartStatusException;

import java.util.Objects;

public enum RestartStatus {
    RESTART("1", true),
    STOP("2", false);

    private final String userInput;
    private final boolean isRestart;

    RestartStatus(String userInput, boolean isRestart) {
        this.userInput = userInput;
        this.isRestart = isRestart;
    }

    public static RestartStatus from(String userInput) {
        if (Objects.equals(userInput, RESTART.userInput)) {
            return RESTART;
        }
        if (Objects.equals(userInput, STOP.userInput)) {
            return STOP;
        }
        throw new NotRestartStatusException("[ERROR] 1 또는 2를 입력해주세요.");
    }

    public boolean isRestart() {
        return isRestart;
    }
}
