package baseball;

import baseball.controller.BaseBallGameController;
import baseball.view.BaseBallGameConsoleView;

public class Application {
    public static void main(String[] args) {
        BaseBallGameController baseBallGameController = new BaseBallGameController(new BaseBallGameConsoleView());
        baseBallGameController.run();
    }
}
