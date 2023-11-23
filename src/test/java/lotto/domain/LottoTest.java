package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.params.provider.Arguments.*;

class LottoTest {
    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("로또 번호의 개수는 6개어야 합니다.");
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("로또 번호에 중복된 숫자가 존재할 수 없습니다.");
    }

    @ParameterizedTest
    @MethodSource("lottoAndExpected")
    @DisplayName("다른 로또와 비교하여 일치하는 로또 번호의 개수를 알 수 있다.")
    void countNumberOfMatches(Lotto other, int expected) {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));

        int actual = lotto.countNumberOfMatches(other);

        assertThat(actual).isEqualTo(expected);
    }

    static Stream<Arguments> lottoAndExpected() {
        return Stream.of(
                arguments(new Lotto(List.of(1, 2, 3, 4, 5, 6)), 6),
                arguments(new Lotto(List.of(1, 12, 13, 14, 15, 16)), 1),
                arguments(new Lotto(List.of(11, 12, 13, 14, 15, 16)), 0)
        );
    }
}