package baseball;

import baseball.controller.BaseBallGameController;
import baseball.repository.BaseBallGameMemoryRepository;
import baseball.service.BaseBallGameService;
import baseball.view.BaseBallGameConsoleView;

public class Application {
    public static void main(String[] args) {
        BaseBallGameService baseBallGameService = new BaseBallGameService(new BaseBallGameMemoryRepository());
        BaseBallGameController baseBallGameController = new BaseBallGameController(new BaseBallGameConsoleView(), baseBallGameService);
        baseBallGameController.run();
    }
}
