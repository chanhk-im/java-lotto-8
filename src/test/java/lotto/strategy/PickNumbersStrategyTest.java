package lotto.strategy;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class PickNumbersStrategyTest {
    @Test
    @DisplayName("[PickFixedNumbersStrategy] 생성자 호출할 때 넣었던 List를 반환한다.")
    void pickFixedNumbers() {
        List<Integer> numbers = List.of(11, 22, 33, 4, 5, 6);

        PickFixedNumbersStrategy strategy = new PickFixedNumbersStrategy(numbers);

        assertThat(strategy.pickNumbers()).containsExactly(11, 22, 33, 4, 5, 6);
    }
}
