package lotto.domain;

import java.util.List;

public record LottoResult(
        int expense,
        Lottos lottos,
        List<Integer> rankCount,
        double rateOfReturn
) {
}
