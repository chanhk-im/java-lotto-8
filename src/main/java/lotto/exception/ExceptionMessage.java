package lotto.exception;

import lotto.constants.LottoConstants;

public enum ExceptionMessage {
    NUMBER_IS_NOT_IN_RANGE("[ERROR] 범위 바깥의 로또 번호입니다."),
    NUMBERS_HAS_DUPLICATED_VALUE("[ERROR] 중복된 로또 번호가 존재합니다."),
    NUMBERS_HAS_WRONG_SIZE(String.format("[ERROR] 로또 번호는 %d개여야 합니다.", LottoConstants.LOTTO_SIZE)),
    EXPENSE_IS_NOT_DIVISIBLE(String.format("[ERROR] 로또 구입 금액은 %d원 단위여야 합니다.", LottoConstants.LOTTO_PRICE)),
    EXPENSE_IS_OUT_OF_RANGE(String.format("\"[ERROR] 로또 구입 금액은 %d원보다 크고, %d원보다 작아야 합니다.\"", 0, LottoConstants.MAX_EXPENSE)),
    INPUT_NUMBER_IS_NOT_A_NUMBER("[ERROR] 숫자를 입력해 주세요.");

    private final String message;

    ExceptionMessage(final String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
