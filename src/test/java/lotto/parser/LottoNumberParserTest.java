package lotto.parser;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class LottoNumberParserTest {
    @Test
    @DisplayName("[LottoNumberParser] \",\"로 이어진 숫자로 된 String을 List<Integer>로 변환한다.")
    void parseNumbersText() {
        String input = "1 ,2, 3, 4,5, 6";
        List<Integer> parsed = LottoNumberParser.parseNumbersText(input);

        assertThat(parsed).containsExactly(1, 2, 3, 4, 5, 6);
    }

    @Test
    @DisplayName("[LottoNumberParser] 숫자, \",\" 외 다른 문자가 있으면 예외가 발생한다.")
    void parseNumbersTextWrongCharacter() {
        String input = "1, 2!3, 4, 5";

        assertThatThrownBy(() -> LottoNumberParser.parseNumbersText(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
