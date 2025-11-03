package lotto.domain;

import java.util.AbstractMap;
import java.util.EnumMap;
import lotto.constants.RankOfSameCount;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class RankCountTest {
    @Test
    @DisplayName("[RankCount] 현재 상금을 계산한다.")
    void calculatePrize() {
        EnumMap<RankOfSameCount, Integer> rankMap = new EnumMap<>(RankOfSameCount.class);

        rankMap.put(RankOfSameCount.FIRST, 2);
        rankMap.put(RankOfSameCount.SECOND, 2);
        rankMap.put(RankOfSameCount.THIRD, 2);
        rankMap.put(RankOfSameCount.FOURTH, 2);

        RankCount rankCount = new RankCount(rankMap);

        assertThat(rankCount.calculatePrize()).isEqualTo(4063100000L * 100);
    }
}
