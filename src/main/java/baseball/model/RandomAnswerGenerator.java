package baseball.model;

import java.util.Random;

public class RandomAnswerGenerator implements AnswerGenerator{

    private final Random random = new Random();

    @Override
    public BaseballNumber generate() {
        // 중복되지 않는 정답 생성
        boolean[] used = new boolean[10];
        StringBuilder answerBuilder = new StringBuilder();

        while (answerBuilder.length() < GameRule.DIGIT_COUNT) {
            int digit = random.nextInt(9) + 1;
            if (!used[digit]) {
                used[digit] = true;
                answerBuilder.append(digit);
            }
        }

        return BaseballNumber.from(answerBuilder.toString());
    }

}
