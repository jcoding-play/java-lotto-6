package lotto.domain;

import java.util.List;

public class Lottos {
    private final List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        validateLottos(lottos);
        this.lottos = lottos;
    }

    private void validateLottos(List<Lotto> lottos) {
        if (lottos.isEmpty()) {
            throw new IllegalArgumentException("로또는 최소 1개 이상이어야 합니다.");
        }
    }
}
