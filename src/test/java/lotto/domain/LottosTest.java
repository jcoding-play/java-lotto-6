package lotto.domain;

import org.assertj.core.api.InstanceOfAssertFactories;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class LottosTest {

    @Test
    @DisplayName("구매한 로또들의 정보를 가진다.")
    void createLottos() {
        List<Lotto> lottoList = List.of(new Lotto(List.of(1, 2, 3, 4, 5, 6)));
        Lottos lottos = new Lottos(lottoList);

        assertThat(lottos).extracting("lottos", InstanceOfAssertFactories.list(Lotto.class))
                .containsExactly(new Lotto(List.of(1, 2, 3, 4, 5, 6)));
    }

    @Test
    @DisplayName("로또의 개수가 1보다 작다면 예외가 발생한다.")
    void invalidLottos() {
        List<Lotto> lottoList = Collections.emptyList();

        assertThatThrownBy(() -> new Lottos(lottoList))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("로또는 최소 1개 이상이어야 합니다.");
    }
}