package baseball.domain;

import baseball.exception.IncludingZeroException;
import baseball.exception.NotThreeDigitsException;
import baseball.exception.NotUniqueDigitsException;
import baseball.exception.StringInputException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class GameNumberTest {

    @Test
    @DisplayName("정수가 아닌 입력을 검증한다")
    void isIntegerTest() {
        // when
        assertThatThrownBy(() -> GameNumber.fromUser("김정교"))
                // then
                .isInstanceOf(StringInputException.class)
                .hasMessageContaining("정수가 아닌 입력입니다.");
    }

    @Test
    @DisplayName("입력이 세자리 수인지 검증한다")
    void isTheeDigitsTest() {
        // when
        assertThatThrownBy(() -> GameNumber.fromUser("1234"))
                // then
                .isInstanceOf(NotThreeDigitsException.class)
                .hasMessageContaining("세 자리 정수가 아닌 입력입니다.");
    }

    @Test
    @DisplayName("각 자리가 서로 다른지 검증한다")
    void isUniqueDigitsTest() {
        // when
        assertThatThrownBy(() -> GameNumber.fromUser("131"))
                // then
                .isInstanceOf(NotUniqueDigitsException.class)
                .hasMessageContaining("입력된 숫자의 각 자리가 서로 다르지 않습니다");
    }

    @Test
    @DisplayName("0을 포함하고있는지 검증한다")
    void isIncludingZeroTest() {
        // when
        assertThatThrownBy(() -> GameNumber.fromUser("103"))
                // then
                .isInstanceOf(IncludingZeroException.class)
                .hasMessageContaining("1-9 사이의 정수만 입력할 수 있습니다.");
    }

}