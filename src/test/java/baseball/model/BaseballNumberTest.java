package baseball.model;

import baseball.exception.InvalidInputException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class BaseballNumberTest {

    // 정상 입력 테스트
    @Test
    @DisplayName("정상 입력이면 BaseballNumber 객체를 생성한다.")
    void from_validInput_success() {
        // given
        String input = "123";

        // when
        BaseballNumber baseballNumber = BaseballNumber.from(input);

        // then
        assert baseballNumber.getDigits().equals(java.util.Arrays.asList(1, 2, 3));
    }

    // 비정상 입력 테스트
    @Test
    @DisplayName("Null 또는 빈 문자열 입력 시 InvalidInputException을 던진다.")
    void from_nullOrEmptyInput_throwsException() {
        assertThrows(InvalidInputException.class, () -> BaseballNumber.from(null));
        assertThrows(InvalidInputException.class, () -> BaseballNumber.from(""));
    }

    @Test
    @DisplayName("자리수가 올바르지 않은 입력 시 InvalidInputException을 던진다.")
    void from_invalidLengthInput_throwsException() {
        assertThrows(InvalidInputException.class, () -> BaseballNumber.from("12"));
        assertThrows(InvalidInputException.class, () -> BaseballNumber.from("1234"));
    }

    @Test
    @DisplayName("숫자가 아닌 문자가 포함된 입력 시 InvalidInputException을 던진다.")
    void from_nonDigitInput_throwsException() {
        assertThrows(InvalidInputException.class, () -> BaseballNumber.from("12a"));
        assertThrows(InvalidInputException.class, () -> BaseballNumber.from("1 2"));
        assertThrows(InvalidInputException.class, () -> BaseballNumber.from("1-2"));    }

    @Test
    @DisplayName("중복된 숫자가 포함된 입력 시 InvalidInputException을 던진다.")
    void from_duplicateDigitsInput_throwsException() {
        assertThrows(InvalidInputException.class, () -> BaseballNumber.from("112"));
        assertThrows(InvalidInputException.class, () -> BaseballNumber.from("121"));
        assertThrows(InvalidInputException.class, () -> BaseballNumber.from("211"));
        assertThrows(InvalidInputException.class, () -> BaseballNumber.from("999"));
    }
}
