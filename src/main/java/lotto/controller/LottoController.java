package lotto.controller;

import java.util.List;
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

    public LottoController(LottoService lottoService, PickNumbersStrategy pickNumbersStrategy) {
        this.lottoService = lottoService;
        this.pickNumbersStrategy = pickNumbersStrategy;
    }

    public void startLotto() {
        OutputView.printInputExpense();
        int expense = InputView.inputExpense();

        Lottos lottos = lottoService.makeLotto(pickNumbersStrategy, expense);

        OutputView.printBoughtLottoMessage(lottoService.calculateLottoCount(expense));
        printLottos(lottos);

        List<Integer> winningNumbers = getWinningNumbers();

        OutputView.printInputBonusNumber();
        int bonusNumber = InputView.inputBonusNumber();

        WinningLotto winningLotto = WinningLotto.lottoAndBonusOf(winningNumbers, bonusNumber);

        RankCount rankCount = lottoService.calculateRankCount(lottos, winningLotto);

        long returnMoney = rankCount.calculatePrize();
        double rateOfReturn = lottoService.calculateRateOfReturn(expense, returnMoney);

        LottoResult result = new LottoResult(lottos, rankCount, rateOfReturn);
        OutputView.printResult(result);
    }

    private List<Integer> getWinningNumbers() {
        OutputView.printInptWinningNumbers();
        String winningNumberText = InputView.inputWinningNumbers();
        return LottoNumberParser.parseNumbersText(winningNumberText);
    }

    private void printLottos(Lottos lottos) {
        lottos.getLottos().forEach(lotto -> {
            OutputView.printBoughtLottoNumber(lotto.getNumbers().stream().sorted().toList());
        });
    }
}
