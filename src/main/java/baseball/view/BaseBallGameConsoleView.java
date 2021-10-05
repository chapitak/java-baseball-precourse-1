package baseball.view;

import baseball.domain.RestartStatus;
import nextstep.utils.Console;

public class BaseBallGameConsoleView implements BaseBallGameView {
    @Override
    public String inputUserNumber() {
        System.out.println("숫자를 입력해주세요 : ");
        return Console.readLine();
    }

    @Override
    public RestartStatus inputRestart() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        return RestartStatus.from(Console.readLine());
    }

    @Override
    public void printGameResult(String gameResult) {
        System.out.println(gameResult);
    }

    @Override
    public void printGameClear() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 끝");
    }
}
