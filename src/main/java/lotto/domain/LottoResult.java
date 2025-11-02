package lotto.domain;

public record LottoResult(
        Lottos lottos,
        RankCount rankCount,
        double rateOfReturn
) {
}
