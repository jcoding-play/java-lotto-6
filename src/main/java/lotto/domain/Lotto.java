package lotto.domain;

import lotto.utils.Constants;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;

public class Lotto {
    private final List<LottoNumber> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = mapLottoNumber(numbers);
    }

    private List<LottoNumber> mapLottoNumber(List<Integer> numbers) {
        return numbers.stream()
                .map(LottoNumber::new)
                .toList();
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != Constants.LOTTO_NUMBERS_SIZE) {
            throw new IllegalArgumentException(
                    String.format("로또 번호의 개수는 %d개어야 합니다.", Constants.LOTTO_NUMBERS_SIZE));
        }
        if (hasDuplicatedNumber(numbers)) {
            throw new IllegalArgumentException("로또 번호에 중복된 숫자가 존재할 수 없습니다.");
        }
    }

    private boolean hasDuplicatedNumber(List<Integer> numbers) {
        return numbers.size() != new HashSet<>(numbers).size();
    }

    public int countNumberOfMatches(Lotto lotto) {
        return (int) numbers.stream()
                .filter(lotto::hasLottoNumber)
                .count();
    }

    private boolean hasLottoNumber(LottoNumber lottoNumber) {
        return numbers.stream()
                .anyMatch(number -> number.equals(lottoNumber));
    }

    public boolean hasBonusNumber(BonusNumber bonusNumber) {
        return numbers.stream()
                .anyMatch(lottoNumber -> lottoNumber.isSameNumber(bonusNumber));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lotto lotto = (Lotto) o;
        return Objects.equals(numbers, lotto.numbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numbers);
    }
}
