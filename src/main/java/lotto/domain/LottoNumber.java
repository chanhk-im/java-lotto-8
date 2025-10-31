package lotto.domain;

import lotto.constants.LottoConstants;
import lotto.exception.LottoNumberIsOutOfRangeException;

public class LottoNumber {
    private final int number;

    private LottoNumber(int number) {
        validateNumberInRange(number);
        this.number = number;
    }

    public static LottoNumber valueOf(int number) {
        return new LottoNumber(number);
    }

    public int getValue() {
        return number;
    }

    private void validateNumberInRange(int number) {
        if (number < LottoConstants.MIN_NUMBER || number > LottoConstants.MAX_NUMBER) {
            throw new LottoNumberIsOutOfRangeException();
        }
    }
}
