package lotto.domain;

public record LottoResult(
        int expense,
        Lottos lottos,
        RankCount rankCount,
        double rateOfReturn
) {
}
