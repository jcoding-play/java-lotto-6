package lotto.domain;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class WinningStatistics {
    private static final int INITIAL_COUNT = 0;
    private static final int PLUS_COUNT = 1;

    private final WinningLotto winningLotto;

    public WinningStatistics(WinningLotto winningLotto) {
        this.winningLotto = winningLotto;
    }

    public Map<LottoRanking, Integer> checkLottoResult(List<Lotto> lottos) {
        Map<LottoRanking, Integer> result = new EnumMap<>(LottoRanking.class);

        for (Lotto lotto : lottos) {
            LottoRanking lottoRanking = winningLotto.findRankingOf(lotto);
            result.put(lottoRanking, result.getOrDefault(lottoRanking, INITIAL_COUNT) + PLUS_COUNT);
        }

        return result;
    }
}
