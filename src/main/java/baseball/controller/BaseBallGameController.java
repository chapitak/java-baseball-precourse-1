package baseball.controller;

import baseball.domain.RestartStatus;
import baseball.service.BaseBallGameService;
import baseball.view.BaseBallGameView;

import java.util.Objects;

public class BaseBallGameController {
    public static final String GAME_CLEAR_CONDITION = "3스트라이크";
    private final BaseBallGameView baseBallGameView;
    private final BaseBallGameService baseBallGameService;

    public BaseBallGameController(BaseBallGameView baseBallGameView, BaseBallGameService baseBallGameService) {
        this.baseBallGameView = baseBallGameView;
        this.baseBallGameService = baseBallGameService;
    }

    /**
     * 랜덤한 숫자를 생성하고 게임을 시행한다. 게임이 종료되면 1 또는 2를 입력받아 게임의 재개를 결정한다
     */
    public void run() {
        RestartStatus restartStatus = RestartStatus.RESTART;
        while (restartStatus.isRestart()) {
            restartStatus = playGame();
        }
    }

    /**
     * 게임을 진행하여 3스트라이크이면 게임을 종료하고 게임 재개 여부를 반환한다
     *
     * @return 게임의 재개여부 상태
     */
    private RestartStatus playGame() {
        baseBallGameService.generateRandomNumber();
        String result = "";
        while (!Objects.equals(result, GAME_CLEAR_CONDITION)) {
            result = playATurn();
        }
        baseBallGameView.printGameClear();
        RestartStatus restartStatus = getUserRestartInput();
        return restartStatus;
    }

    /**
     * 재시작 여부를 입력받아 RestartStatus로 반환한다
     *
     * @return 재시작 여부
     */
    private RestartStatus getUserRestartInput() {
        RestartStatus restartStatus = null;
        while (restartStatus == null) {
            restartStatus = getUserRestartInputTry();
        }
        return restartStatus;
    }

    private RestartStatus getUserRestartInputTry() {
        RestartStatus restartStatus = null;
        try {
            restartStatus = baseBallGameView.inputRestart();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        return restartStatus;
    }

    /**
     * 입력을 받아 생성된 랜덤한 숫자와 비교하는 게임을 한 턴 시행하고 결과값을 문자열로 반환한다
     *
     * @return 두 숫자를 비교한 결과값
     */
    private String playATurn() {
        String userNumber = baseBallGameView.inputUserNumber();
        String gameResult = "";
        try {
            gameResult = baseBallGameService.computeResult(userNumber);
            baseBallGameView.printGameResult(gameResult);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return gameResult;
    }
}
