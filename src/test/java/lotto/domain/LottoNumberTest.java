package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoNumberTest {
    @Test
    @DisplayName("[LottoNumber] 로또 번호는 숫자 하나를 넣어서 생성할 수 있다.")
    void createLottoNumber() {
        int number = 3;

        LottoNumber lottoNumber = LottoNumber.valueOf(number);

        assertThat(lottoNumber.getValue()).isEqualTo(3);
    }

    @ParameterizedTest
    @ValueSource(ints = {46, 100, -4, 0})
    @DisplayName("[LottoNumber] 1~45 사이의 수가 아니면 IllegalArgumentException 예외가 발생한다")
    void createLottoNumberException(int number) {

        assertThatThrownBy(() -> LottoNumber.valueOf(number)).isInstanceOf(IllegalArgumentException.class);
    }
}
