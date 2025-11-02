package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import lotto.strategy.PickNumbersStrategy;

public class Lottos {
    private final List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public static Lottos makeLottos(PickNumbersStrategy strategy, int count) {
        List<Lotto> lottos = new ArrayList<Lotto>();

        for (int i = 0; i < count; i++) {
            List<Integer> numbers = strategy.pickNumbers();
            Lotto lotto = Lotto.numbersOf(numbers);
            lottos.add(lotto);
        }

        return new Lottos(lottos);
    }

    public List<Lotto> getLottos() {
        return lottos;
    }
}
