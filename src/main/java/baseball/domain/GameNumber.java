package baseball.domain;

import baseball.exception.IncludingZeroException;
import baseball.exception.NotThreeDigitsException;
import baseball.exception.NotUniqueDigitsException;
import baseball.exception.StringInputException;
import nextstep.utils.Randoms;

import java.util.ArrayList;
import java.util.HashSet;

import static baseball.utility.GameUtility.convertIntToList;

public class GameNumber {
    private ArrayList<Integer> gameNumber;

    public GameNumber(ArrayList<Integer> gameNumber) {
        validateGameNumber(gameNumber);
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
        validateIncludingZero(gameNumber);
    }

    /**
     * 입력받은 세 자리 숫자 중 0을 포함할 경우 예외를 던진다
     *
     * @param gameNumber
     */
    private static void validateIncludingZero(ArrayList<Integer> gameNumber) {
        if (gameNumber.contains(0)) {
            throw new IncludingZeroException("1-9 사이의 정수만 입력할 수 있습니다.");
        }
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
        int parsedUserInput = parseUserInput(userInput);
        ArrayList<Integer> gameNumberList = convertIntToList(parsedUserInput);
        return new GameNumber(gameNumberList);
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

    /**
     * 서로 다른 세 자리 정수를 생성하여 반환한다.
     *
     * @return 서로 다른 세 자리 정수
     */
    public static GameNumber random() {
        ArrayList<Integer> newNumber = new ArrayList<>();
        while (newNumber.size() != 3) {
            addSingleNumber(newNumber);
        }
        return new GameNumber(newNumber);
    }

    private static void addSingleNumber(ArrayList<Integer> newNumber) {
        int newSingleNumber = Randoms.pickNumberInRange(1, 9);
        if (!newNumber.contains(newSingleNumber)) {
            newNumber.add(newSingleNumber);
        }
    }
}
