package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.*;

class WinningStatisticsTest {
    private WinningStatistics winningStatistics;

    @BeforeEach
    void setUp() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        BonusNumber bonusNumber = new BonusNumber(7);
        WinningLotto winningLotto = new WinningLotto(lotto, bonusNumber);
        
        winningStatistics = new WinningStatistics(winningLotto);
    }

    @Test
    @DisplayName("사용자가 구매한 로또에 대해 전체 당첨 내역을 알 수 있다.")
    void checkLottoResult() {
        List<Lotto> lottos = getLottos();
        Map<LottoRanking, Integer> result = winningStatistics.checkLottoResult(lottos);

        assertThat(result).contains(entry(LottoRanking.FIFTH, 1), entry(LottoRanking.NOTHING, 7));
    }
    
    @Test
    @DisplayName("사용자가 구매한 로또에 대해 전체 수익률을 계산할 수 있다.")
    void calculateRateOfReturn() {
        List<Lotto> lottos = getLottos();
        Map<LottoRanking, Integer> result = winningStatistics.checkLottoResult(lottos);

        double rateOfReturn = winningStatistics.calculateRateOfReturn(result);

        assertThat(rateOfReturn).isEqualTo(62.5);
    }

    private List<Lotto> getLottos() {
        return List.of(
                new Lotto(List.of(8, 21, 23, 41, 42, 43)),
                new Lotto(List.of(3, 5, 11, 16, 32, 38)),
                new Lotto(List.of(7, 11, 16, 35, 36, 44)),
                new Lotto(List.of(1, 8, 11, 31, 41, 42)),
                new Lotto(List.of(13, 14, 16, 38, 42, 45)),
                new Lotto(List.of(7, 11, 30, 40, 42, 43)),
                new Lotto(List.of(2, 13, 22, 32, 38, 45)),
                new Lotto(List.of(1, 3, 5, 14, 22, 45))
        );
    }
}