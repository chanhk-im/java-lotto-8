package lotto.constants;

import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.assertj.core.api.Assertions.*;

public class RankOfSameCountTest {
    @ParameterizedTest
    @MethodSource("paramsForFindRankTest")
    @DisplayName("[RankOfSameCount] 일치 번호 수 + 보너스 번호 일치로 등수를 찾을 수 있다.")
    void findRank(int sameCount, boolean isBonusNumberSame, String rankName) {
        assertThat(RankOfSameCount.findRank(sameCount, isBonusNumberSame).name()).isSameAs(rankName);
    }

    static Stream<Arguments> paramsForFindRankTest() {
        return Stream.of(
                Arguments.arguments(5, true, "SECOND"),
                Arguments.arguments(5, false, "THIRD"),
                Arguments.arguments(6, true, "FIRST"),
                Arguments.arguments(6, false, "FIRST"),
                Arguments.arguments(2, false, "NONE")
        );
    }
}
