package lotto.domain;

import java.util.HashSet;
import java.util.List;

public class Lotto {
    private static final int LOTTO_NUMBERS_SIZE = 6;

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
        if (numbers.size() != LOTTO_NUMBERS_SIZE) {
            throw new IllegalArgumentException(
                    String.format("로또 번호의 개수는 %d개어야 합니다.", LOTTO_NUMBERS_SIZE));
        }
        if (hasDuplicatedNumber(numbers)) {
            throw new IllegalArgumentException("로또 번호에 중복된 숫자가 존재할 수 없습니다.");
        }
    }

    private boolean hasDuplicatedNumber(List<Integer> numbers) {
        return numbers.size() != new HashSet<>(numbers).size();
    }
}
