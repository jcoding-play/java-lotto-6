package lotto.domain;

import lotto.utils.Constants;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class WinningStatistics {
    private static final int PLUS_COUNT = 1;
    private static final int INITIAL_COUNT = 0;
    private static final int INITIAL_AMOUNT = 0;
    private static final int HUNDRED = 100;

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

    public double calculateRateOfReturn(Map<LottoRanking, Integer> result) {
        int purchaseAmount = calculatePurchaseAmount(result);
        int totalPrizeMoney = calculateTotalPrizeMoney(result);

        return (double) totalPrizeMoney / purchaseAmount * HUNDRED;
    }

    private int calculatePurchaseAmount(Map<LottoRanking, Integer> result) {
        return result.values()
                .stream()
                .map(count -> count * Constants.LOTTO_PRICE)
                .reduce(INITIAL_AMOUNT, Integer::sum);
    }

    private int calculateTotalPrizeMoney(Map<LottoRanking, Integer> result) {
        return result.keySet()
                .stream()
                .map(lottoRanking -> calculatePrizeMoneyOf(result, lottoRanking))
                .reduce(INITIAL_AMOUNT, Integer::sum);
    }

    private int calculatePrizeMoneyOf(Map<LottoRanking, Integer> result, LottoRanking lottoRanking) {
        int prizeMoney = lottoRanking.getPrizeMoney();
        int count = result.get(lottoRanking);

        return prizeMoney * count;
    }
}
