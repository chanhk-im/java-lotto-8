package lotto.strategy;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import lotto.constants.LottoConstants;

public class PickRandomLottoNumbersStrategy implements PickNumbersStrategy {
    private final int LOTTO_NUMBER_COUNT = 6;

    @Override
    public List<Integer> pickNumbers() {
        return Randoms.pickUniqueNumbersInRange(
                LottoConstants.MIN_NUMBER,
                LottoConstants.MAX_NUMBER,
                LOTTO_NUMBER_COUNT
        );
    }
}
