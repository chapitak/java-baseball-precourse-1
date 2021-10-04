package baseball.controller;

import baseball.view.BaseBallGameView;

public class BaseBallGameController {
    private BaseBallGameView baseBallGameView;

    public BaseBallGameController(BaseBallGameView baseBallGameView) {
        this.baseBallGameView = baseBallGameView;
    }

    public void run() {
        String userNumber = baseBallGameView.inputUserNumber();

    }

}
