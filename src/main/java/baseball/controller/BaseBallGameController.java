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
            playATurn();
        }
    }

    private void playATurn() {
        String userNumber = baseBallGameView.inputUserNumber();
        try {
            System.out.println(baseBallGameService.computeResult(userNumber));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
