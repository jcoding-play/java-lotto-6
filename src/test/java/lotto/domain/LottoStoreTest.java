package lotto.domain;

import org.assertj.core.api.InstanceOfAssertFactories;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class LottoStoreTest {

    @Test
    @DisplayName("구입 금액에 해당하는 만큼 로또를 발행할 수 있다.")
    void buyLotto() {
        LottoStore lottoStore = new LottoStore();
        Lottos lottos = lottoStore.buyLotto(new PurchaseAmount(3000));

        assertThat(lottos).extracting("lottos", InstanceOfAssertFactories.list(Lotto.class))
                .hasSize(3);
    }
}