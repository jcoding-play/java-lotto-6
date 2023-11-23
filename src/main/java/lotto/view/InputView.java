package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.view.validator.InputValidator;

public class InputView {
    private static final String READ_PURCHASE_AMOUNT_MESSAGE = "구입금액을 입력해 주세요.";

    public int readPurchaseAmount() {
        System.out.println(READ_PURCHASE_AMOUNT_MESSAGE);
        String input = Console.readLine();

        InputValidator.validatePurchaseAmount(input);
        return Integer.parseInt(input);
    }
}
