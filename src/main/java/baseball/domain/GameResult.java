package baseball.domain;

import java.util.ArrayList;

public class GameResult {
    public static final String STRIKE = "스트라이크";
    public static final String BALL = "볼";
    public static final String NOTHING = "낫싱";
    public static final String RESULT_DELIMITER = " ";
    private final int strikes;
    private final int balls;

    public GameResult(int strikes, int balls) {
        this.strikes = strikes;
        this.balls = balls;
    }

    /**
     * 두 숫자를 비교하여 게임결과를 반환한다
     *
     * @param gameNumber1
     * @param gameNumber2
     * @return 게임 결과
     */
    public static GameResult computeResult(GameNumber gameNumber1, GameNumber gameNumber2) {
        return gameNumber1.computeResult(gameNumber2);
    }

    /**
     * 스트라이크와 볼의 개수를 통해 게임 결과를 반환하는 팩토리 메서드
     *
     * @param strikes
     * @param balls
     * @return 게임결과를 생성하여 반환한다
     */
    public static GameResult of(int strikes, int balls) {
        return new GameResult(strikes, balls);
    }

    /**
     * 게임결과를 문자열로 만들어 반환한다
     *
     * @return 게임결과를 문자열로 변환한 값
     */
    public String toResultString() {
        ArrayList<String> resultList = new ArrayList<>();
        addResultString(resultList);
        return String.join(RESULT_DELIMITER, resultList);
    }

    private void addResultString(ArrayList<String> resultList) {
        if (strikes > 0) {
            resultList.add(strikes + STRIKE);
        }
        if (balls > 0) {
            resultList.add(balls + BALL);
        }
        if (strikes == 0 && balls == 0) {
            resultList.add(NOTHING);
        }
    }
}
