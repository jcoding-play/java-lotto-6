package lotto.domain;

import java.util.Objects;

public class PurchaseAmount {
    private static final int LOTTO_PRICE = 1000;
    private static final int VALID_CHANGE = 0;

    private final int purchaseAmount;

    public PurchaseAmount(int purchaseAmount) {
        validatePurchaseAmount(purchaseAmount);
        this.purchaseAmount = purchaseAmount;
    }

    private void validatePurchaseAmount(int purchaseAmount) {
        if (purchaseAmount < LOTTO_PRICE) {
            throw new IllegalArgumentException(
                    String.format("구입 금액은 최소 %,d원 이상이어야 합니다.", LOTTO_PRICE));
        }
        if (isInvalidPurchaseAmount(purchaseAmount)) {
            throw new IllegalArgumentException(
                    String.format("구입 금액은 %,d원 단위어야 합니다.", LOTTO_PRICE));
        }
    }

    private boolean isInvalidPurchaseAmount(int purchaseAmount) {
        return purchaseAmount % LOTTO_PRICE != VALID_CHANGE;
    }

    public int divideByLottoPrice() {
        return purchaseAmount / LOTTO_PRICE;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PurchaseAmount that = (PurchaseAmount) o;
        return purchaseAmount == that.purchaseAmount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(purchaseAmount);
    }
}
