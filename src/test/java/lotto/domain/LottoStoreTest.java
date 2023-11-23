package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class LottoStoreTest {

    @Test
    @DisplayName("구입 금액에 해당하는 만큼 로또를 발행할 수 있다.")
    void buyLotto() {
        LottoStore lottoStore = new LottoStore();
        List<Lotto> lottos = lottoStore.buyLotto(new PurchaseAmount(3000));

        assertThat(lottos.size()).isEqualTo(3);
    }
}