package lotto.exception;

public enum ExceptionMessage {
    NUMBER_IS_NOT_IN_RANGE("[ERROR] 범위 바깥의 로또 번호입니다."),
    NUMBERS_HAS_DUPLICATED_VALUE("[ERROR] 중복된 로또 번호가 존재합니다."),
    NUMBERS_HAS_WRONG_SIZE("[ERROR] 로또 번호는 6개여야 합니다."),
    EXPENSE_IS_NOT_DIVISIBLE("[ERROR] 로또 구입 금액이 나누어떨어지지 않습니다."),
    INPUT_NUMBER_IS_NOT_A_NUMBER("[ERROR] 숫자를 입력해 주세요.");

    private final String message;

    ExceptionMessage(final String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
