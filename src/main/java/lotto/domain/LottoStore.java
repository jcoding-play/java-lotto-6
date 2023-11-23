package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;
import java.util.stream.Stream;

import static lotto.utils.Constants.*;

public class LottoStore {

    public List<Lotto> buyLotto(PurchaseAmount purchaseAmount) {
        int result = purchaseAmount.divideByLottoPrice();
        return generateLottos(result);
    }

    private List<Lotto> generateLottos(int size) {
        return Stream.generate(this::generateLotto)
                .limit(size)
                .toList();
    }

    private Lotto generateLotto() {
        return new Lotto(pickUniqueNumbers());
    }

    private List<Integer> pickUniqueNumbers() {
        return Randoms.pickUniqueNumbersInRange(MINIMUM_LOTTO_NUMBER, MAXIMUM_LOTTO_NUMBER, LOTTO_NUMBERS_SIZE);
    }
}
