package lotto.domain;

import java.util.List;

public class WinningLotto {
    Lotto lotto;
    LottoNumber bonusNumber;

    private WinningLotto(Lotto lotto, LottoNumber bonusNumber) {
        validateBonusNumberDuplicated(lotto, bonusNumber);

        this.lotto = lotto;
        this.bonusNumber = bonusNumber;
    }

    public static WinningLotto lottoAndBonusOf(List<Integer> numbers, int bonus) {
        return new WinningLotto(Lotto.numbersOf(numbers), LottoNumber.valueOf(bonus));
    }

    private void validateBonusNumberDuplicated(Lotto lotto, LottoNumber bonusNumber) {
        if (lotto.contains(bonusNumber.getValue())) {
            throw new IllegalArgumentException();
        }
    }

    public int compareLottoTo(Lotto otherLotto) {
        return lotto.getSameElementCount(otherLotto);
    }

    public boolean compareBonusNumberTo(Lotto other) {
        return other.contains(bonusNumber.getValue());
    }
}
