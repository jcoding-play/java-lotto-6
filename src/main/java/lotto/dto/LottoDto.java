package lotto.dto;

import lotto.domain.Lotto;
import lotto.domain.LottoNumber;

import java.util.List;
import java.util.stream.Collectors;

public class LottoDto {
    private final List<Integer> numbers;

    private LottoDto(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public static LottoDto from(Lotto lotto) {
        return toDto(lotto.getNumbers());
    }

    private static LottoDto toDto(List<LottoNumber> numbers) {
        return numbers.stream()
                .map(LottoNumber::getLottoNumber)
                .collect(Collectors.collectingAndThen(Collectors.toList(), LottoDto::new));
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
