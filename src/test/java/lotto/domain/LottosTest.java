package lotto.domain;

import java.util.List;

import lotto.strategy.PickFixedNumbersStrategy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class LottosTest {
    @Test
    @DisplayName("[Lottos] Lotto list를 가져올 수 있다.")
    void getList() {
        Lotto lotto = Lotto.numbersOf(List.of(1, 2, 3, 4, 5, 6));
        Lottos lottos = new Lottos(List.of(lotto));

        assertThat(lottos.getLottos()).containsExactly(lotto);
    }

    @Test
    @DisplayName("[Lottos] 전략에 따라 원하는 개수만큼 로또를 만들 수 있다.")
    void makeLottoProperCount() {
        List<Integer> fixedNumbers = List.of(1, 2, 3, 4, 5, 6);
        PickFixedNumbersStrategy pickFixedNumbersStrategy = new PickFixedNumbersStrategy(fixedNumbers);

        Lottos lottos = Lottos.makeLottos(pickFixedNumbersStrategy, 6);

        assertThat(lottos.getLottos()).hasSize(6);
    }

    @Test
    @DisplayName("[Lottos] 전략에 맞는 번호들로 로또를 만들 수 있다.")
    void makeLottoProperNumber() {
        List<Integer> fixedNumbers = List.of(1, 2, 3, 4, 5, 6);
        PickFixedNumbersStrategy pickFixedNumbersStrategy = new PickFixedNumbersStrategy(fixedNumbers);

        Lottos lottos = Lottos.makeLottos(pickFixedNumbersStrategy, 1);

        assertThat(lottos.getLottos().getFirst().getNumbers())
                .containsExactly(1, 2, 3, 4, 5, 6);
    }
}
