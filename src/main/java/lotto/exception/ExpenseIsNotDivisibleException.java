package lotto.exception;

public class ExpenseIsNotDivisibleException extends IllegalArgumentException {
    public ExpenseIsNotDivisibleException() {
        super(ExceptionMessage.EXPENSE_IS_NOT_DIVISIBLE.getMessage());
    }
}
