package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public record RankCount(List<Integer> rankCount) {

    @Override
    public List<Integer> rankCount() {
        return new ArrayList<Integer>(rankCount);
    }
}
