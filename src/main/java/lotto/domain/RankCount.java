package lotto.domain;

import java.util.EnumMap;
import lotto.constants.RankOfSameCount;

public record RankCount(EnumMap<RankOfSameCount, Integer> rankCount) {

    @Override
    public EnumMap<RankOfSameCount, Integer> rankCount() {
        return new EnumMap<>(rankCount);
    }

    public long calculatePrize() {
        return rankCount.keySet().stream()
                .mapToLong(rankOfSameCount ->
                        (long) rankOfSameCount.getPrizeMoney() * rankCount.get(rankOfSameCount))
                .sum();
    }
}
