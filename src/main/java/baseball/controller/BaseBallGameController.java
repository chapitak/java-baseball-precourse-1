package baseball.controller;

import baseball.service.BaseBallGameService;
import baseball.view.BaseBallGameView;

import java.util.Objects;

public class BaseBallGameController {
    private final BaseBallGameView baseBallGameView;
    private final BaseBallGameService baseBallGameService;

    public BaseBallGameController(BaseBallGameView baseBallGameView, BaseBallGameService baseBallGameService) {
        this.baseBallGameView = baseBallGameView;
        this.baseBallGameService = baseBallGameService;
    }

    /**
     * 랜덤한 숫자를 생성하고 게임을 시행한다. 결과가 3스트라이크가 나올 때까지 시행을 반복한다. 3스트라이크가 나오면 게임을 끝낸다
     */
    public void run() {
        baseBallGameService.generateRandomNumber();
        String result = "";
        while (!Objects.equals(result, "3스트라이크")) {
            result = playATurn();
        }
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 끝");
    }

    /**
     * 입력을 받아 생성된 랜덤한 숫자와 비교하는 게임을 한 턴 시행하고 결과값을 문자열로 반환한다
     *
     * @return 두 숫자를 비교한 결과값
     */
    private String playATurn() {
        String userNumber = baseBallGameView.inputUserNumber();
        String result = "";
        try {
            result = baseBallGameService.computeResult(userNumber);
            System.out.println(result);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return result;
    }
}
