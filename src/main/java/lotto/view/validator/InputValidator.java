package lotto.view.validator;

import org.junit.platform.commons.util.StringUtils;

import java.util.regex.Pattern;

public class InputValidator {
    private static final Pattern ONLY_DIGIT = Pattern.compile("-?[0-9]+");

    private InputValidator() {
    }

    protected static void validateInput(String input) {
        if (StringUtils.isBlank(input)) {
            throw new IllegalArgumentException("입력은 공백일 수 없습니다.");
        }
    }

    public static void validatePurchaseAmount(String input) {
        validateInput(input);

        if (isNotDigit(input)) {
            throw new IllegalArgumentException(
                    String.format("구입금액에 대한 입력은 숫자만 가능합니다. (현재 입력된 값=%s)", input));
        }    
    }

    private static boolean isNotDigit(String input) {
        return !ONLY_DIGIT.matcher(input)
                .matches();
    }
}
