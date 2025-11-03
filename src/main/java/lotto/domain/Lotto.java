package lotto.domain;

import java.util.List;
import lotto.constants.LottoConstants;
import lotto.exception.LottoNumbersHaveDuplicatedValueException;
import lotto.exception.LottoNumbersWrongSizeException;

public class Lotto {
    private final List<LottoNumber> numbers;

    private Lotto(List<LottoNumber> lottoNumbers) {
        this.numbers = lottoNumbers;

    }

    public static Lotto numbersOf(List<Integer> numbers) {
        validate(numbers);

        return new Lotto(numbers.stream().map(LottoNumber::valueOf).toList());
    }

    private static void validate(List<Integer> numbers) {
        validateNumbersIsNotDuplicated(numbers);

        validateNumbersSize(numbers);
    }

    private static void validateNumbersSize(List<Integer> numbers) {
        if (numbers.size() != LottoConstants.LOTTO_SIZE) {
            throw new LottoNumbersWrongSizeException();
        }
    }

    private static void validateNumbersIsNotDuplicated(List<Integer> numbers) {
        if (numbers.size() > numbers.stream().distinct().count()) {
            throw new LottoNumbersHaveDuplicatedValueException();
        }
    }

    public List<Integer> getNumbers() {
        return numbers.stream().map(LottoNumber::getValue).toList();
    }

    public boolean contains(int number) {
        return getNumbers().contains(number);
    }

    public int getSameElementCount(Lotto other) {
        long sameElementCount = other.getNumbers()
                .stream()
                .filter(this::contains)
                .count();

        return Long.valueOf(sameElementCount).intValue();
    }
}
