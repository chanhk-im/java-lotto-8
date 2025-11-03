package lotto.service;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.Map;
import lotto.constants.RankOfSameCount;
import lotto.domain.LottoResult;
import lotto.domain.Lottos;
import lotto.domain.RankCount;
import lotto.domain.WinningLotto;
import lotto.exception.ExpenseIsNotDivisibleException;
import lotto.strategy.PickNumbersStrategy;

public class LottoService {
    private static final int LOTTO_PRICE = 1000;
    private static final Map<Integer, Integer> RANK_OF_SAME_NUMBER_COUNT = Map.of(

    );

    public Lottos makeLotto(PickNumbersStrategy strategy, int expense) {
        int lottoCount = calculateLottoCount(expense);

        return Lottos.makeLottos(strategy, lottoCount);
    }

    public int calculateLottoCount(int expense) {
        if (expense % LOTTO_PRICE != 0) {
            throw new ExpenseIsNotDivisibleException();
        }

        return expense / LOTTO_PRICE;
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
        return ((double) returnMoney / expense) * 100;
    }
}
