package lotto.exception;

public class InputNumberIsNotANumberException extends IllegalArgumentException {
    public InputNumberIsNotANumberException() {
        super(ExceptionMessage.INPUT_NUMBER_IS_NOT_A_NUMBER.getMessage());
    }
}
