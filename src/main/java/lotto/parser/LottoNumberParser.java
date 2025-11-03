package lotto.parser;

import java.util.Arrays;
import java.util.List;
import lotto.exception.InputNumberIsNotANumberException;

public final class LottoNumberParser {
    private LottoNumberParser() {
    }

    public static List<Integer> parseNumbersText(String text) {
        try {
            return Arrays.stream(text.split(","))
                    .map(numberText -> Integer.parseInt(numberText.trim()))
                    .toList();
        } catch (NumberFormatException e) {
            throw new InputNumberIsNotANumberException();
        }
    }
}
