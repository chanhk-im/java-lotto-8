package lotto.exception;

public class InputExpenseIsNotANumberException extends IllegalArgumentException {
    public InputExpenseIsNotANumberException() {
        super(ExceptionMessage.INPUT_EXPENSE_IS_NOT_A_NUMBER.getMessage());
    }
}
