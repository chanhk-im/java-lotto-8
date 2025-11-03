package lotto.service;

import static lotto.constants.LottoConstants.LOTTO_PRICE;
import static lotto.constants.LottoConstants.MAX_EXPENSE;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.Map;
import lotto.constants.LottoConstants;
import lotto.constants.RankOfSameCount;
import lotto.domain.LottoResult;
import lotto.domain.Lottos;
import lotto.domain.RankCount;
import lotto.domain.WinningLotto;
import lotto.exception.ExpenseIsNotDivisibleException;
import lotto.exception.ExpenseIsOutOfRangeException;
import lotto.strategy.PickNumbersStrategy;

public class LottoService {

    public Lottos makeLotto(PickNumbersStrategy strategy, int lottoCount) {
        return Lottos.makeLottos(strategy, lottoCount);
    }

    public int calculateLottoCount(int expense) {
        validateExpenseIsDivisible(expense);
        validateExpenseIsInRange(expense);

        return expense / LOTTO_PRICE;
    }

    private void validateExpenseIsDivisible(int expense) {
        if (expense % LOTTO_PRICE != 0) {
            throw new ExpenseIsNotDivisibleException();
        }
    }

    private void validateExpenseIsInRange(int expense) {
        if (expense <= 0 || expense > MAX_EXPENSE) {
            throw new ExpenseIsOutOfRangeException();
        }
    }

    public RankCount calculateRankCount(Lottos lottos, WinningLotto winningLotto) {
        EnumMap<RankOfSameCount, Integer> rankCount = new EnumMap<>(RankOfSameCount.class);

        Arrays.stream(RankOfSameCount.values()).forEach(rank -> rankCount.put(rank, 0));

        lottos.getLottos().forEach(lotto -> {
            int sameCount = winningLotto.compareLottoTo(lotto);
            boolean isBonusNumberSame = winningLotto.compareBonusNumberTo(lotto);

            RankOfSameCount rankOfSameCount = RankOfSameCount.findRank(sameCount, isBonusNumberSame);

            rankCount.put(rankOfSameCount, rankCount.get(rankOfSameCount) + 1);
        });

        return new RankCount(rankCount);
    }

    public double calculateRateOfReturn(int expense, long returnMoney) {
        return toPercent((double) returnMoney / expense);
    }

    private double toPercent(double rate) {
        return rate * 100;
    }
}
