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
    public static final int SIZE_OF_GAME_NUMBER = 3;
    public static final int START_INCLUSIVE_RANDOM_NUMBER = 1;
    public static final int END_INCLUSIVE_RANDOM_NUMBER = 9;
    private final ArrayList<Integer> gameNumber;

    public GameNumber(ArrayList<Integer> gameNumber) {
        validateGameNumber(gameNumber);
        this.gameNumber = gameNumber;
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
     * 입력받은 정수가 세 자리 숫자인지를 검증하여 예외를 던진다.
     *
     * @param gameNumber
     */
    private static void validateThreeDigits(ArrayList<Integer> gameNumber) {
        if (gameNumber.size() != SIZE_OF_GAME_NUMBER) {
            throw new NotThreeDigitsException("[ERROR] 세 자리 정수가 아닌 입력입니다.");
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
            throw new NotUniqueDigitsException("[ERROR] 입력된 숫자의 각 자리가 서로 다르지 않습니다");
        }
    }

    /**
     * 입력받은 세 자리 숫자 중 0을 포함할 경우 예외를 던진다
     *
     * @param gameNumber
     */
    private static void validateIncludingZero(ArrayList<Integer> gameNumber) {
        if (gameNumber.contains(0)) {
            throw new IncludingZeroException("[ERROR] 1-9 사이의 정수만 입력할 수 있습니다.");
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
            throw new StringInputException("[ERROR] 정수가 아닌 입력입니다.");
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
        while (newNumber.size() != SIZE_OF_GAME_NUMBER) {
            addSingleNumber(newNumber);
        }
        return new GameNumber(newNumber);
    }

    private static void addSingleNumber(ArrayList<Integer> newNumber) {
        int newSingleNumber = Randoms.pickNumberInRange(START_INCLUSIVE_RANDOM_NUMBER, END_INCLUSIVE_RANDOM_NUMBER);
        if (!newNumber.contains(newSingleNumber)) {
            newNumber.add(newSingleNumber);
        }
    }

    /**
     * 비교대상인 GameNumber를 주입받아 스트라이크와 볼의 개수를 구한 후 GameResult를 반환한다.
     *
     * @param target
     * @return 게임 결과를 계산한 GameResult
     */
    public GameResult computeResult(GameNumber target) {
        int strikes = computeStrikes(target);
        int balls = computeBalls(target);

        return GameResult.of(strikes, balls);
    }

    /**
     * 볼의 개수를 연산 후 리턴한다
     *
     * @param target
     * @return 볼의 개수
     */
    private int computeBalls(GameNumber target) {
        int balls = 0;
        for (int i = 0; i < gameNumber.size(); i++) {
            balls = addBall(target, balls, i);
        }
        return balls;
    }

    /**
     * 볼의 개수를 구할 때 사용되며 볼의 개수를 하나씩 더해서 반환한다
     *
     * @param target
     * @param balls
     * @param i
     * @return 해당될 시 볼의 개수를 1씩 증가하여 반환
     */
    private int addBall(GameNumber target, int balls, int i) {
        ArrayList<Integer> indexRemovedTarget = new ArrayList<>(target.gameNumber);
        indexRemovedTarget.remove(i);
        if (indexRemovedTarget.contains(gameNumber.get(i))) {
            balls++;
        }
        return balls;
    }

    /**
     * 스트라이크의 개수를 연산 후 리턴한다
     *
     * @param target
     * @return 스트라이크의 개수
     */
    private int computeStrikes(GameNumber target) {
        int strikes = 0;
        for (int i = 0; i < gameNumber.size(); i++) {
            strikes = addStrike(target, strikes, i);
        }
        return strikes;
    }

    /**
     * 스트라이크의 개수를 구할 때 사용되며 스트라이크의 개수를 하나씩 더하여 반환한다
     *
     * @param target
     * @param strikes
     * @param i
     * @return 해당될 시 스트라이크의 개수를 1개씩 더해서 반환
     */
    private int addStrike(GameNumber target, int strikes, int i) {
        if (gameNumber.get(i).equals(target.gameNumber.get(i))) {
            strikes++;
        }
        return strikes;
    }
}
