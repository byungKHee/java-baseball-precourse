package baseball.model;

import baseball.exception.InvalidInputException;

import java.util.ArrayList;
import java.util.List;

public class BaseballNumber {
    private final List<Integer> digits;

    public BaseballNumber(List<Integer> digits) {
        this.digits = digits;
    }

    public static BaseballNumber from(String input) {
        // 1. 문자열 검증
        validateInput(input);
        // 2. 문자열을 숫자 리스트로 변환
        List<Integer> digits = new ArrayList<>();
        for (char ch : input.toCharArray()) {
            digits.add(Character.getNumericValue(ch));
        }
        return new BaseballNumber(digits);
    }

    private static void validateInput(String input) {
        checkNotNullOrEmpty(input);
        checkLength(input);
        checkAllDigits(input);
        checkRange(input);
        checkNoDuplicates(input);
    }

    private static void checkNotNullOrEmpty(String input) {
        if (input == null || input.isEmpty()) {
            throw new InvalidInputException("입력은 null 또는 빈 문자열일 수 없습니다.");
        }
    }

    private static void checkLength(String input) {
        if (input.length() != GameRule.DIGIT_COUNT) {
            throw new InvalidInputException("입력은 " + GameRule.DIGIT_COUNT + "자리 숫자여야 합니다.");
        }
    }

    private static void checkAllDigits(String input) {
        for (char ch : input.toCharArray()){
            if (!Character.isDigit(ch)) {
                throw new InvalidInputException("입력은 숫자만 포함해야 합니다.");
            }
        }
    }

    private static void checkRange(String input) {
        for (char ch : input.toCharArray()) {
            int digit = Character.getNumericValue(ch);
            if (digit < GameRule.MIN_NUMBER || digit > GameRule.MAX_NUMBER) {
                throw new InvalidInputException("각 숫자는 " + GameRule.MIN_NUMBER + "에서 " + GameRule.MAX_NUMBER + " 사이여야 합니다.");
            }
        }
    }

    private static void checkNoDuplicates(String input) {
        boolean[] seen = new boolean[10]; // 0-9 숫자 추적
        for (char ch : input.toCharArray()) {
            int digit = Character.getNumericValue(ch);
            if (seen[digit]) {
                throw new InvalidInputException("입력된 숫자에 중복이 있어서는 안됩니다.");
            }
            seen[digit] = true;
        }
    }

    public List<Integer> getDigits() {
        return digits;
    }

}
