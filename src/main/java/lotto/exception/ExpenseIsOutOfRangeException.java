package lotto.exception;

public class ExpenseIsOutOfRangeException extends IllegalArgumentException {
    public ExpenseIsOutOfRangeException() {
        super(ExceptionMessage.EXPENSE_IS_OUT_OF_RANGE.getMessage());
    }
}
