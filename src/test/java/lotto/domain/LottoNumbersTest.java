package lotto.domain;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoNumbersTest {
    @Test
    @DisplayName("[LottoNumbers] 생성자 호출할 때 인자로 List<Integer>를 넣어줘야 함")
    void createLottoNumbers() {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);

        LottoNumbers lottoNumbers = new LottoNumbers(numbers);

        assertThat(lottoNumbers.getNumbers()).containsExactly(1, 2, 3, 4, 5, 6);
    }

    @Test
    @DisplayName("[LottoNumbers] 생성자 호출할 때 List에 중복된 값이 있으면 IllegalArgumentException 에러 발생함")
    void createDuplicatedLottoNumbers() {
        List<Integer> numbers = List.of(1, 1, 3, 4, 5, 6);

        assertThatThrownBy(() -> new LottoNumbers(numbers)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("[LottoNumbers] LottoNumbers의 멤버 변수들은 불변성을 보장한다.")
    void immutableMemberVariable() {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);

        LottoNumbers lottoNumbers = new LottoNumbers(numbers);

        assertThat(lottoNumbers.getNumbers()).containsExactly(1, 2, 3, 4, 5, 6);
    }
}
