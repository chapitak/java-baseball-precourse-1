package baseball.view;

import baseball.domain.RestartStatus;

public interface BaseBallGameView {
    /**
     * 사용자 입력을 받아 문자열 그대로 반환한다
     *
     * @return 사용자 입력
     */
    String inputUserNumber();

    RestartStatus inputRestart();

    void printGameResult(String gameResult);

    void printGameClear();

    void printErrorMessage(String message);
}
