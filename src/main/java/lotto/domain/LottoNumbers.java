package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import lotto.exception.LottoNumbersHaveDuplicatedValueException;

public class LottoNumbers {
    private List<LottoNumber> lottoNumbers;

    public LottoNumbers(List<Integer> numbers) {
        validateNumbersIsNotDuplicated(numbers);

        lottoNumbers = numbers.stream().map(LottoNumber::valueOf).toList();
    }

    private void validateNumbersIsNotDuplicated(List<Integer> numbers) {
        if (numbers.size() > numbers.stream().distinct().count()) {
            throw new LottoNumbersHaveDuplicatedValueException();
        }
    }

    public List<Integer> getNumbers() {
        return lottoNumbers.stream().map(LottoNumber::getValue).toList();
    }
}
