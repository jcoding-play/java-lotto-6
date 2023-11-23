package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.*;

class WinningLottoTest {
    private WinningLotto winningLotto;

    @BeforeEach
    void setUp() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        BonusNumber bonusNumber = new BonusNumber(7);

        winningLotto = new WinningLotto(lotto, bonusNumber);
    }

    @Test
    @DisplayName("당첨 로또는 중복되지 않는 숫자 6개와 보너스 번호 1개를 가진다.")
    void createWinningLotto() {
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

    @ParameterizedTest
    @MethodSource("lottoAndLottoRanking")
    @DisplayName("사용자의 로또와 비교하여 당첨 순위를 알 수 있다.")
    void findRankingOf(Lotto lotto, LottoRanking expected) {
        LottoRanking actual = winningLotto.findRankingOf(lotto);

        assertThat(actual).isEqualTo(expected);
    }

    static Stream<Arguments> lottoAndLottoRanking() {
        return Stream.of(
                arguments(new Lotto(List.of(1, 2, 3, 4, 5, 6)), LottoRanking.FIRST),
                arguments(new Lotto(List.of(1, 2, 3, 4, 5, 7)), LottoRanking.SECOND),
                arguments(new Lotto(List.of(1, 2, 3, 4, 5, 16)), LottoRanking.THIRD),
                arguments(new Lotto(List.of(1, 2, 3, 4, 15, 16)), LottoRanking.FOURTH),
                arguments(new Lotto(List.of(1, 2, 3, 14, 15, 16)), LottoRanking.FIFTH),
                arguments(new Lotto(List.of(1, 2, 13, 14, 15, 16)), LottoRanking.NOTHING)
        );
    }
}