package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.exception.InputExpenseIsNotANumberException;

public final class InputView {
    private InputView() {
    }

    private static int readInteger() {
        String line = Console.readLine();
        try {
            return Integer.parseInt(line);
        } catch (NumberFormatException e) {
            throw new InputExpenseIsNotANumberException();
        }
    }

    public static int inputExpense() {
        return readInteger();
    }

    public static String inputWinningNumbers() {
        return Console.readLine();
    }

    public static int inputBonusNumber() {
        return readInteger();
    }
}
