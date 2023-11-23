package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class PurchaseAmountTest {

    @Test
    @DisplayName("로또를 구입하려는 금액에 대한 정보를 알 수 있다.")
    void createPurchaseAmount() {
        PurchaseAmount purchaseAmount = new PurchaseAmount(1000);
        assertThat(purchaseAmount).isEqualTo(new PurchaseAmount(1000));
    }

    @Test
    @DisplayName("구입 금액이 1,000원보다 작다면 예외가 발생한다.")
    void lessThanMinPurchaseAmount() {
        assertThatThrownBy(() -> new PurchaseAmount(999))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("구입 금액은 최소 1,000원 이상이어야 합니다.");
    }

    @Test
    @DisplayName("구입 금액이 1,000원 단위로 나누어 떨어지지 않으면 예외가 발생한다.")
    void invalidPurchaseAmount() {
        assertThatThrownBy(() -> new PurchaseAmount(1100))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("구입 금액은 1,000원 단위어야 합니다.");
    }
}