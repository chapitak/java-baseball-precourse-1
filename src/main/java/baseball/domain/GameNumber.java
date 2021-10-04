package baseball.domain;

import baseball.exception.NotThreeDigitsException;
import baseball.exception.StringInputException;
import baseball.exception.NotUniqueDigitsException;

import java.util.ArrayList;
import java.util.HashSet;

public class GameNumber {
    private ArrayList<Integer> gameNumber;

    public GameNumber(ArrayList<Integer> gameNumber) {
        this.gameNumber = gameNumber;
    }

    /**
     * 정수를 입력받아 GameNumber를 생성하여 리턴하는 팩토리 메서드입니다.
     *
     * @param gameNumber
     * @return 생성된 GameNumber
     */
    public static GameNumber of(int gameNumber) {
        ArrayList<Integer> gameNumberList = convertIntToList(gameNumber);
        validateGameNumber(gameNumberList);
        return new GameNumber(gameNumberList);
    }

    /**
     * 입력받은 세 자리 정수를 검증한다.
     *
     * @param gameNumber
     */
    private static void validateGameNumber(ArrayList<Integer> gameNumber) {
        validateThreeDigits(gameNumber);
        validateUniqueDigits(gameNumber);
    }

    /**
     * 입력받은 세 자리 숫자의 각 자리 숫자 중 동일한 숫자가 있을 경우 예외를 던진다
     *
     * @param gameNumber
     */
    private static void validateUniqueDigits(ArrayList<Integer> gameNumber) {
        HashSet<Integer> gameNumberSet = new HashSet<>(gameNumber);
        if (gameNumberSet.size() != gameNumber.size()) {
            throw new NotUniqueDigitsException("입력된 숫자의 각 자리가 서로 다르지 않습니다");
        }
    }

    /**
     * 게임을 위한 숫자를 정수형으로 입력받아 각 자리를 담은 ArrayList<Integer>로 반환하여 리턴합니다.
     *
     * @param gameNumber
     * @return 각 자리의 숫자를 담은 ArrayList<Integer>
     */
    static ArrayList<Integer> convertIntToList(int gameNumber) {
        ArrayList<Integer> gameNumberList = new ArrayList<>();
        int gameNumberToCompute = gameNumber;
        int digits = (int) (Math.log10(gameNumber) + 1);
        for (int i = 1; i <= digits; i++) {
            gameNumberToCompute = (int) (gameNumber / Math.pow(10, (digits - i)));
            gameNumberList.add(gameNumberToCompute % 10);
        }
        return gameNumberList;
    }

    /**
     * 입력받은 정수가 세 자리 숫자인지를 검증하여 예외를 던진다.
     *
     * @param gameNumber
     */
    private static void validateThreeDigits(ArrayList<Integer> gameNumber) {
        if (gameNumber.size() != 3) {
            throw new NotThreeDigitsException("세 자리 정수가 아닌 입력입니다.");
        }
    }

    /**
     * 사용자로부터 String을 입력받아 정수로 변환하여 GameNumber를 생성하는 팩토리 메서드입니다.
     *
     * @param userInput
     * @return 생성된 GameNumber
     */
    public static GameNumber fromUser(String userInput) {
        int userInputNumber = 0;
        userInputNumber = parseUserInput(userInput);
        return GameNumber.of(userInputNumber);
    }

    /**
     * String 형식의 사용자 입력을 int 형식으로 파싱하여 리턴한다.
     * 파싱에 실패하면 StringInputException를 던진다.
     *
     * @param userInput
     * @return int형식으로 변환된 사용자입력
     */
    private static int parseUserInput(String userInput) {
        int userInputNumber;
        try {
            userInputNumber = Integer.parseInt(userInput);
        } catch (NumberFormatException e) {
            e.printStackTrace();
            throw new StringInputException("정수가 아닌 입력입니다.");
        }
        return userInputNumber;
    }
}
