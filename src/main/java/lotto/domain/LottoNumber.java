package lotto.domain;

import lotto.exception.LottoNumberIsOutOfRangeException;

public class LottoNumber {
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;

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
        if (number < MIN_NUMBER || number > MAX_NUMBER) {
            throw new LottoNumberIsOutOfRangeException();
        }
    }
}
