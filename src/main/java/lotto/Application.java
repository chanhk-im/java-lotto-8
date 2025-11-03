package lotto;

import lotto.controller.LottoController;
import lotto.service.LottoService;
import lotto.strategy.PickRandomLottoNumbersStrategy;

public class Application {
    public static void main(String[] args) {
        LottoController lottoController = initController();

        lottoController.startLotto();
    }

    private static LottoController initController() {
        LottoService lottoService = new LottoService();
        PickRandomLottoNumbersStrategy strategy = new PickRandomLottoNumbersStrategy();
        return new LottoController(lottoService, strategy);
    }
}
