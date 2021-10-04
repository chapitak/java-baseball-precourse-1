package baseball.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class GameResultTest {

    @ParameterizedTest
    @CsvSource(value = {"123:243:1스트라이크 1볼", "123:123:3스트라이크", "321:132:3볼"}, delimiter = ':')
    void computeResultTest(String input1, String input2, String resultString) {
        // given
        GameNumber gameNumber1 = GameNumber.fromUser(input1);
        GameNumber gameNumber2 = GameNumber.fromUser(input2);

        // when
        GameResult gameResult = GameResult.computeResult(gameNumber1, gameNumber2);

        // then
        assertThat(gameResult.toResultString()).isEqualTo(resultString);
    }
}