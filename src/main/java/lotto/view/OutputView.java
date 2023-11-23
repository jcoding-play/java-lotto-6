package lotto.view;

import lotto.dto.LottoDto;
import lotto.dto.LottosDto;

import java.util.List;

public class OutputView {

    public void printUserLottos(LottosDto lottosDto) {
        List<LottoDto> lottos = lottosDto.getLottos();

        printLottoCount(lottos.size());
        printLottoNumbers(lottos);
    }

    private void printLottoCount(int count) {
        System.out.printf("%d개를 구매했습니다.\n", count);
    }

    private void printLottoNumbers(List<LottoDto> lottos) {
        System.out.print(generateLottoNumbersMessage(lottos));
    }

    private String generateLottoNumbersMessage(List<LottoDto> lottos) {
        StringBuilder messageBuilder = new StringBuilder();

        for (LottoDto lotto : lottos) {
            messageBuilder.append(lotto.getNumbers())
                    .append(System.lineSeparator());
        }

        return messageBuilder.toString();
    }
}
