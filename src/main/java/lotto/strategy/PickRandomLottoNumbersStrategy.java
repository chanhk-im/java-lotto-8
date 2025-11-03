package lotto.strategy;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import lotto.constants.LottoConstants;

public class PickRandomLottoNumbersStrategy implements PickNumbersStrategy {

    @Override
    public List<Integer> pickNumbers() {
        return Randoms.pickUniqueNumbersInRange(
                LottoConstants.MIN_NUMBER,
                LottoConstants.MAX_NUMBER,
                LottoConstants.LOTTO_SIZE
        );
    }
}
