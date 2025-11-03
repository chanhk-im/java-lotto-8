package lotto.view;

import java.text.DecimalFormat;
import java.util.List;
import java.util.StringJoiner;
import lotto.constants.RankOfSameCount;
import lotto.domain.LottoResult;
import lotto.domain.RankCount;

public final class OutputView {
    private static final String LOTTO_INPUT_EXPENSE_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String LOTTO_BOUGHT_LOTTO_MESSAGE_FORMAT = "\n%d개를 구매했습니다.\n";
    private static final String LOTTO_NUMBER_FORMAT = "[%s]\n";
    private static final String LOTTO_INPUT_WINNING_NUMBERS_MESSAGE = "\n당첨 번호를 입력해 주세요.";
    private static final String LOTTO_INPUT_BONUS_NUMBER_MESSAGE = "\n보너스 번호를 입력해 주세요.";
    private static final String LOTTO_RESULT_HEADER_MESSAGE = "\n당첨 통계\n---";
    private static final String LOTTO_RESULT_FORMAT = "%d개 일치 (%s원) - %d개\n";
    private static final String LOTTO_RESULT_BONUS_FORMAT = "%d개 일치, 보너스 볼 일치 (%s원) - %d개\n";
    private static final String LOTTO_RATE_OF_RETURN_FORMAT = "총 수익률은 %.1f%%입니다.\n";

    private static final String LOTTO_NUMBER_DELIMITER = ", ";
    private static final String RETURN_MONEY_FORMAT = "###,###";

    private OutputView() {
    }

    public static void printInputExpense() {
        System.out.println(LOTTO_INPUT_EXPENSE_MESSAGE);
    }

    public static void printBoughtLottoMessage(int count) {
        System.out.printf(LOTTO_BOUGHT_LOTTO_MESSAGE_FORMAT, count);
    }

    public static void printBoughtLottoNumber(List<Integer> numbers) {
        StringJoiner joiner = new StringJoiner(LOTTO_NUMBER_DELIMITER);

        numbers.forEach((number -> {
            joiner.add(String.valueOf(number));
        }));
        String lottoNumberText = joiner.toString();

        System.out.printf(LOTTO_NUMBER_FORMAT, lottoNumberText);
    }

    public static void printInptWinningNumbers() {
        System.out.println(LOTTO_INPUT_WINNING_NUMBERS_MESSAGE);
    }

    public static void printInputBonusNumber() {
        System.out.println(LOTTO_INPUT_BONUS_NUMBER_MESSAGE);
    }

    public static void printResult(LottoResult result) {
        System.out.println(LOTTO_RESULT_HEADER_MESSAGE);
        printRanks(result.rankCount());
        printRateOfReturn(result.rateOfReturn());
    }

    private static void printRanks(RankCount rankCount) {
        DecimalFormat formatter = new DecimalFormat(RETURN_MONEY_FORMAT);

        rankCount.rankCount().forEach(((rankOfSameCount, count) -> {
            if (rankOfSameCount.equals(RankOfSameCount.NONE)) {
                return;
            }

            String printFormat = LOTTO_RESULT_FORMAT;
            if (rankOfSameCount.isBonusNumberSame()) {
                printFormat = LOTTO_RESULT_BONUS_FORMAT;
            }

            System.out.printf(printFormat, rankOfSameCount.getSameCount(),
                    formatter.format(rankOfSameCount.getPrizeMoney()), count);
        }));
    }

    private static void printRateOfReturn(double rateOfReturn) {
        System.out.printf(LOTTO_RATE_OF_RETURN_FORMAT, rateOfReturn);
    }
}
