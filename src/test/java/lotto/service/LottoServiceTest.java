package lotto.service;

import java.util.List;
import lotto.domain.LottoResult;
import lotto.domain.Lottos;
import lotto.domain.RankCount;
import lotto.domain.WinningLotto;
import lotto.strategy.PickFixedNumbersStrategy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class LottoServiceTest {
    private LottoService lottoService;

    @BeforeEach
    void setUp() {
        lottoService = new LottoService();
    }

    @Test
    @DisplayName("[LottoService] 로또 살 금액만큼 로또 생성해서 반환한다.")
    void makeLotto() {
        int money = 5000;
        List<Integer> fixedNumbers = List.of(1, 2, 3, 4, 5, 6);
        PickFixedNumbersStrategy pickFixedNumbersStrategy = new PickFixedNumbersStrategy(fixedNumbers);

        Lottos lottos = lottoService.makeLotto(pickFixedNumbersStrategy, 5000);

        assertThat(lottos.getLottos()).hasSize(5);
    }

    @Test
    @DisplayName("[LottoService] 로또 몇 개를 살 수 있는지 계산한다.")
    void calculateLottoCount() {
        int money = 5000;

        assertThat(lottoService.calculateLottoCount(money)).isEqualTo(5);
    }

    @Test
    @DisplayName("[LottoService] 로또 가격이 나누어떨어지지 않으면 예외가 발생한다.")
    void calculateLottoCountException() {
        int money = 5500;

        assertThatThrownBy(() -> lottoService.calculateLottoCount(money)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("[LottoService] 로또 당첨 결과를 계산하고 반환한다.")
    void calculateRankCount() {
        List<Integer> fixedNumbers = List.of(1, 2, 3, 4, 5, 6);
        PickFixedNumbersStrategy pickFixedNumbersStrategy = new PickFixedNumbersStrategy(fixedNumbers);
        Lottos lottos = Lottos.makeLottos(pickFixedNumbersStrategy, 5);

        WinningLotto winningLotto = WinningLotto.lottoAndBonusOf(List.of(1, 2, 3, 4, 5, 6), 8);

        RankCount rankCount = lottoService.calculateRankCount(lottos, winningLotto);

        assertThat(rankCount.rankCount().values()).containsExactly(5, 0, 0, 0, 0, 0);
    }

    @Test
    @DisplayName("[LottoService] 로또 수익률을 계산한다.")
    void calculateRateOfReturn() {
        int expense = 5000;
        long returnMoney = 2000000000;

        assertThat(lottoService.calculateRateOfReturn(expense, returnMoney))
                .isEqualTo((2000000000d) / 5000, withPrecision(0.1d));
    }
}
