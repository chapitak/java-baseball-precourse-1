package baseball.utility;

import java.util.ArrayList;

public class GameUtility {
    /**
     * 게임을 위한 숫자를 정수형으로 입력받아 각 자리를 담은 ArrayList<Integer>로 반환하여 리턴합니다.
     *
     * @param gameNumber
     * @return 각 자리의 숫자를 담은 ArrayList<Integer>
     */
    public static ArrayList<Integer> convertIntToList(int gameNumber) {
        ArrayList<Integer> gameNumberList = new ArrayList<>();
        int gameNumberToCompute;
        int digits = (int) (Math.log10(gameNumber) + 1);
        for (int i = 1; i <= digits; i++) {
            gameNumberToCompute = (int) (gameNumber / Math.pow(10, (digits - i)));
            gameNumberList.add(gameNumberToCompute % 10);
        }
        return gameNumberList;
    }
}
