package lotto.strategy;

import java.util.List;

public class PickFixedNumbersStrategy implements PickNumbersStrategy {
    private final List<Integer> fixedNumbers;

    public PickFixedNumbersStrategy(List<Integer> fixedNumbers) {
        this.fixedNumbers = fixedNumbers;
    }

    @Override
    public List<Integer> pickNumbers() {
        return fixedNumbers;
    }
}
