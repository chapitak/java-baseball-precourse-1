package baseball.utility;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static baseball.utility.GameUtility.convertIntToList;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class GameUtilityTest {

    @Test
    @DisplayName("정수의 각 자리를 리스트로 변환한다")
    void convertIntToListTest() {
        //given
        int gameNumber = 234;

        //when
        ArrayList<Integer> integers = convertIntToList(gameNumber);

        //then
        assertThat(integers).isEqualTo(Arrays.asList(2, 3, 4));
    }
}