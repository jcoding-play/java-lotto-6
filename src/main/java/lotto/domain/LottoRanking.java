package lotto.domain;

import java.util.Arrays;
import java.util.function.BiPredicate;

public enum LottoRanking {
    FIRST((numberOfMatches, hasBonusNumber) -> numberOfMatches == 6, 2_000_000_000),
    SECOND((numberOfMatches, hasBonusNumber) -> numberOfMatches == 5 && hasBonusNumber, 30_000_000),
    THIRD((numberOfMatches, hasBonusNumber) -> numberOfMatches == 5, 1_500_000),
    FOURTH((numberOfMatches, hasBonusNumber) -> numberOfMatches == 4, 50_000),
    FIFTH((numberOfMatches, hasBonusNumber) -> numberOfMatches == 3, 5_000),
    NOTHING((numberOfMatches, hasBonusNumber) -> numberOfMatches == 0, 0);

    private final BiPredicate<Integer, Boolean> predicate;
    private final int prizeMoney;

    LottoRanking(BiPredicate<Integer, Boolean> predicate, int prizeMoney) {
        this.predicate = predicate;
        this.prizeMoney = prizeMoney;
    }

    public static LottoRanking of(int numberOfMatches, boolean hasBonusNumber) {
        return Arrays.stream(values())
                .filter(lottoRanking -> lottoRanking.isMatch(numberOfMatches, hasBonusNumber))
                .findFirst()
                .orElse(NOTHING);
    }

    private boolean isMatch(int numberOfMatches, boolean hasBonusNumber) {
        return predicate.test(numberOfMatches, hasBonusNumber);
    }

    public int getPrizeMoney() {
        return prizeMoney;
    }
}
