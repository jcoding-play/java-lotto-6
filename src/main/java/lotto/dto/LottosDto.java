package lotto.dto;

import lotto.domain.Lotto;
import lotto.domain.Lottos;

import java.util.List;
import java.util.stream.Collectors;

public class LottosDto {
    private final List<LottoDto> lottos;

    private LottosDto(List<LottoDto> lottos) {
        this.lottos = lottos;
    }

    public static LottosDto from(Lottos lottos) {
        return toDto(lottos.getLottos());
    }

    private static LottosDto toDto(List<Lotto> lottos) {
        return lottos.stream()
                .map(LottoDto::from)
                .collect(Collectors.collectingAndThen(Collectors.toList(), LottosDto::new));
    }

    public List<LottoDto> getLottos() {
        return lottos;
    }
}
