package baseball.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RandomAnswerGeneratorTest {

    @Test
    @DisplayName("랜덤으로 생성된 답안이 게임 규칙을 준수하는지 확인합니다.")
    void generateRandomAnswer_compliesWithGameRules() {
        // given
        AnswerGenerator generator = new RandomAnswerGenerator();

        // when
        BaseballNumber answer = generator.generate();

        // then
        // 숫자의 개수가 규칙에 맞는지 확인
        assert answer.getDigits().size() == GameRule.DIGIT_COUNT;

        // 각 숫자가 규칙에 맞는지 확인
        for (Integer digit : answer.getDigits()) {
            assert digit >= GameRule.MIN_NUMBER && digit <= GameRule.MAX_NUMBER;
        }

        // 중복된 숫자가 없는지 확인
        long uniqueCount = answer.getDigits().stream().distinct().count();
        assert uniqueCount == GameRule.DIGIT_COUNT;
    }
}
