package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.view.validator.InputValidator;

public class InputView {
    private static final String READ_PURCHASE_AMOUNT_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String READ_WINNING_NUMBERS_MESSAGE = "당첨 번호를 입력해 주세요.";
    private static final String READ_BONUS_NUMBER_MESSAGE = "보너스 번호를 입력해 주세요.";

    public int readPurchaseAmount() {
        System.out.println(READ_PURCHASE_AMOUNT_MESSAGE);
        String input = Console.readLine();

        InputValidator.validatePurchaseAmount(input);
        return Integer.parseInt(input);
    }

    public String readWinningNumbers() {
        System.out.println(READ_WINNING_NUMBERS_MESSAGE);
        String input = Console.readLine();

        InputValidator.validateWinningNumbers(input);
        return input;
    }

    public int readBonusNumber() {
        System.out.println(READ_BONUS_NUMBER_MESSAGE);
        String input = Console.readLine();

        InputValidator.validateBonusNumber(input);
        return Integer.parseInt(input);
    }
}
