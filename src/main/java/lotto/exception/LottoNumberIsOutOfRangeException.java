package lotto.exception;

public class LottoNumberIsOutOfRangeException extends IllegalArgumentException {
    public LottoNumberIsOutOfRangeException() {
        super(ExceptionMessage.NUMBER_IS_NOT_IN_RANGE.getMessage());
    }
}
