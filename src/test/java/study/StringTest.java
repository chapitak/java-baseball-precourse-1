package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringTest {
    @Test
    @DisplayName("쉼표를 기준으로 배열을 만든다")
    void simpleSplitTest() {
        // given
        String splitTarget1 = "1,2";
        String splitTarget2 = "1";

        // when
        String[] splitedTarget1 = splitTarget1.split(",");
        String[] splitedTarget2 = splitTarget2.split(",");

        // then
        assertThat(splitedTarget1).containsExactly("1", "2");
        assertThat(splitedTarget2).containsExactly("1");
    }

    @Test
    @DisplayName("subString을 활용해서 괄호를 제거한다")
    void substringTest() {
        // given
        String substringTarget = "(1,2)";

        // when
        String substringedTarget = substringTarget.substring(1, 4);

        // then
        assertThat(substringedTarget).isEqualTo("1,2");
    }

    @Test
    @DisplayName("첫 번째 인덱스에 있는 char를 리턴한다")
    void charAtTest() {
        // given
        String given = "abc";

        // when
        char character = given.charAt(1);

        // then
        assertThat(character).isEqualTo('b');
    }

    @Test
    @DisplayName("charAt의 index가 2를 초과하여 StringIndexOutOfBoundsException을 발생시킨다.")
    void charAtFailTest() {
        // given
        String given = "abc";

        // when
        assertThatThrownBy(() -> given.charAt(3))
                // then
                .isInstanceOf(IndexOutOfBoundsException.class)
                .hasMessageContaining("String index out of range: 3");
    }
}
