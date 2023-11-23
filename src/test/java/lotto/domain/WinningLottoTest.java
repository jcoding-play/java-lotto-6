package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class WinningLottoTest {

    @Test
    @DisplayName("당첨 로또는 중복되지 않는 숫자 6개와 보너스 번호 1개를 가진다.")
    void createWinningLotto() {
        WinningLotto winningLotto = new WinningLotto(new Lotto(List.of(1, 2, 3, 4, 5, 6)), new BonusNumber(7));
        assertThat(winningLotto).isEqualTo(new WinningLotto(new Lotto(List.of(1, 2, 3, 4, 5, 6)), new BonusNumber(7)));
    }

    @Test
    @DisplayName("로또 번호 중 보너스 번호와 일치하는 숫자가 존재하면 예외가 발생한다.")
    void invalidWinningLotto() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        BonusNumber bonusNumber = new BonusNumber(6);

        assertThatThrownBy(() -> new WinningLotto(lotto, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("로또 번호 중 보너스 번호와 일치하는 로또 번호가 존재할 수 없습니다.");
    }
}