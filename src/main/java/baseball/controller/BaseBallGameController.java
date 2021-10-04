package baseball.controller;

import baseball.service.BaseBallGameService;
import baseball.view.BaseBallGameView;

public class BaseBallGameController {
    private BaseBallGameView baseBallGameView;
    private BaseBallGameService baseBallGameService;

    public BaseBallGameController(BaseBallGameView baseBallGameView, BaseBallGameService baseBallGameService) {
        this.baseBallGameView = baseBallGameView;
        this.baseBallGameService = baseBallGameService;
    }

    public void run() {
        baseBallGameService.generateRandomNumber();
        while (true) {
            String userNumber = baseBallGameView.inputUserNumber();
            System.out.println(baseBallGameService.computeResult(userNumber));
        }
    }
}
