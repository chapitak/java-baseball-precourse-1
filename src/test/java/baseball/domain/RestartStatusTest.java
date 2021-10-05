package baseball.domain;

import baseball.exception.NotRestartStatusException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class RestartStatusTest {

    @Test
    @DisplayName("1 또는 2 외의 입력을 검증한다")
    void from() {
        // when
        assertThatThrownBy(() -> RestartStatus.from("3"))
                // then
                .isInstanceOf(NotRestartStatusException.class)
                .hasMessageContaining("[ERROR] 1 또는 2를 입력해주세요.");
    }
}