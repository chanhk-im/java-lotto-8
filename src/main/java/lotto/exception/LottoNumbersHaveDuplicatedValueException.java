package lotto.exception;

public class LottoNumbersHaveDuplicatedValueException extends IllegalArgumentException {
    public LottoNumbersHaveDuplicatedValueException() {
        super(ExceptionMessage.NUMBERS_HAS_DUPLICATED_VALUE.getMessage());
    }
}
