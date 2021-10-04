package baseball.view;

import nextstep.utils.Console;

public class BaseBallGameConsoleView implements BaseBallGameView {
    @Override
    public String inputUserNumber() {
        System.out.println("숫자를 입력해주세요 : ");
        return Console.readLine();
    }
}
