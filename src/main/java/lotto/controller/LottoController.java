package lotto.controller;

import java.util.List;
import java.util.NoSuchElementException;
import lotto.domain.Lotto;
import lotto.domain.LottoResult;
import lotto.domain.Lottos;
import lotto.domain.RankCount;
import lotto.domain.WinningLotto;
import lotto.parser.LottoNumberParser;
import lotto.service.LottoService;
import lotto.strategy.PickNumbersStrategy;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private final LottoService lottoService;
    private final PickNumbersStrategy pickNumbersStrategy;

    private int expense;
    private int lottoCount;
    private Lottos lottos;
    private List<Integer> winningNumbers;
    private int bonusNumber;

    public LottoController(LottoService lottoService, PickNumbersStrategy pickNumbersStrategy) {
        this.lottoService = lottoService;
        this.pickNumbersStrategy = pickNumbersStrategy;
    }

    public void startLotto() {
        multipleTryMakeLottos();

        OutputView.printBoughtLottoMessage(lottoCount);
        printLottos(lottos);

        multipleTryGetWinningNumbers();

        multipleTryGetBonusNumbers();

        WinningLotto winningLotto = WinningLotto.lottoAndBonusOf(winningNumbers, bonusNumber);

        RankCount rankCount = lottoService.calculateRankCount(lottos, winningLotto);

        long returnMoney = rankCount.calculatePrize();
        double rateOfReturn = lottoService.calculateRateOfReturn(expense, returnMoney);

        LottoResult result = new LottoResult(rankCount, rateOfReturn);
        OutputView.printResult(result);
    }

    private void getExpense() {
        OutputView.printInputExpense();
        expense = InputView.inputExpense();
    }

    private void multipleTryMakeLottos() {
        while (true) {
            try {
                getExpense();
                lottoCount = lottoService.calculateLottoCount(expense);
                lottos = lottoService.makeLotto(pickNumbersStrategy, lottoCount);

                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }

        }
    }

    private void multipleTryGetWinningNumbers() {
        while (true) {
            try {
                getWinningNumbers();
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void getWinningNumbers() {
        OutputView.printInptWinningNumbers();
        String winningNumberText = InputView.inputWinningNumbers();
        winningNumbers = LottoNumberParser.parseNumbersText(winningNumberText);
    }

    private void multipleTryGetBonusNumbers() {
        while (true) {
            try {
                OutputView.printInputBonusNumber();
                bonusNumber = InputView.inputBonusNumber();
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void printLottos(Lottos lottos) {
        lottos.getLottos().forEach(lotto -> {
            OutputView.printBoughtLottoNumber(lotto.getNumbers().stream().sorted().toList());
        });
    }
}
