package baseball.domain;

import java.util.ArrayList;

public class GameResult {
    private int strikes;
    private int balls;

    public GameResult(int strikes, int balls) {
        this.strikes = strikes;
        this.balls = balls;
    }

    /**
     * 두 숫자를 비교하여 게임결과를 반환한다
     * @param gameNumber1
     * @param gameNumber2
     * @return 게임 결과
     */
    public static GameResult computeResult(GameNumber gameNumber1, GameNumber gameNumber2) {
        return gameNumber1.computeResult(gameNumber2);
    }

    /**
     * 스트라이크와 볼의 개수를 통해 게임 결과를 반환하는 팩토리 메서드
     * @param strikes
     * @param balls
     * @return 게임결과를 생성하여 반환한다
     */
    public static GameResult of(int strikes, int balls) {
        return new GameResult(strikes, balls);
    }

    /**
     * 게임결과를 문자열로 만들어 반환한다
     * @return 게임결과를 문자열로 변환한 값
     */
    public String toResultString() {
        ArrayList<String> resultList = new ArrayList<>();
        if (strikes > 0) {
            resultList.add(strikes + "스트라이크");
        }
        if (balls > 0) {
            resultList.add(balls + "볼");
        }
        return String.join(" ", resultList);
    }
}
