package lotto.constants;

import java.util.Arrays;
import java.util.Optional;

public enum RankOfSameCount {
    FIRST(6, false, 2000000000),
    SECOND(5, true, 30000000),
    THIRD(5, false, 1500000),
    FOURTH(4, false, 50000),
    FIFTH(3, false, 5000);

    private final int sameCount;
    private final boolean isBonusNumberSame;
    private final int prizeMoney;

    RankOfSameCount(int sameCount, boolean isBonusNumberSame, int prizeMoney) {
        this.sameCount = sameCount;
        this.isBonusNumberSame = isBonusNumberSame;
        this.prizeMoney = prizeMoney;
    }

    public int getSameCount() {
        return sameCount;
    }

    public boolean isBonusNumberSame() {
        return isBonusNumberSame;
    }

    public int getPrizeMoney() {
        return prizeMoney;
    }

    public static RankOfSameCount findRank(int sameCount, boolean isBonusNumberSame) {
        RankOfSameCount rankOfSameCount = findRankBySameCountAndIsBonusNumberSame(sameCount, isBonusNumberSame);

        if (rankOfSameCount == null && isBonusNumberSame) {
            return findRankBySameCountAndIsBonusNumberSame(sameCount, false);
        }

        return rankOfSameCount;
    }

    private static RankOfSameCount findRankBySameCountAndIsBonusNumberSame(int sameCount, boolean isBonusNumberSame) {
        return Arrays.stream(values())
                .filter(rank -> rank.sameCount == sameCount && rank.isBonusNumberSame == isBonusNumberSame)
                .findFirst()
                .orElse(null);
    }
}
