package lotto.domain;

import java.util.List;
import lotto.exception.LottoNumbersHaveDuplicatedValueException;

public class Lotto {
    private final List<LottoNumber> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);

        this.numbers = numbers.stream().map(LottoNumber::valueOf).toList();
    }

    private void validate(List<Integer> numbers) {
        validateNumbersIsNotDuplicated(numbers);

        validateNumbersSize(numbers);
    }

    private void validateNumbersSize(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }

    private void validateNumbersIsNotDuplicated(List<Integer> numbers) {
        if (numbers.size() > numbers.stream().distinct().count()) {
            throw new LottoNumbersHaveDuplicatedValueException();
        }
    }

    // TODO: 추가 기능 구현
}
