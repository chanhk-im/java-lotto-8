package lotto.domain;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class WinningLottoTest {
    @Test
    @DisplayName("[WinningLotto] 다른 Lotto와 자신의 Lotto를 비교해서 같은 number 개수를 리턴한다.")
    void compareLottoToOther() {
        WinningLotto winningLotto = WinningLotto.lottoAndBonusOf(List.of(5, 6, 7, 8, 9, 10), 11);
        Lotto otherLotto = Lotto.numbersOf(List.of(1, 2, 3, 4, 5, 6));

        assertThat(winningLotto.compareLottoTo(otherLotto)).isEqualTo(2);
    }

    @Test
    @DisplayName("[WinningLotto] 다른 Lotto와 자신의 bonus number를 비교해서 같은 값이 있으면 true를 리턴한다.")
    void compareBonusNumberToOtherLotto() {
        WinningLotto winningLotto = WinningLotto.lottoAndBonusOf(List.of(5, 6, 7, 8, 9, 10), 11);
        Lotto otherLotto = Lotto.numbersOf(List.of(1, 2, 3, 5, 7, 11));

        assertThat(winningLotto.compareBonusNumberTo(otherLotto)).isTrue();
    }

    @Test
    @DisplayName("[WinningLotto] Lotto와 bonusNumber 간 중복이 있으면 IllegalArgumentException 예외가 발생한다.")
    void lottoAndBonusNumberAreDuplicated() {
        assertThatThrownBy(() -> WinningLotto.lottoAndBonusOf(List.of(5, 6, 7, 8, 9, 10), 5))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
