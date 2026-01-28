package baseball.model;

import java.util.List;

public class Judgement {
    private final int strike;
    private final int ball;

    private Judgement(int strike, int ball) {
        this.strike = strike;
        this.ball = ball;
    }

    public static Judgement of(BaseballNumber answer, BaseballNumber guess) {
        int strike = countStrike(answer, guess);
        int ball = countBall(answer, guess);

        return new Judgement(strike, ball);
    }

    private static int countStrike(BaseballNumber answer, BaseballNumber guess) {
        int count = 0;
        List<Integer> answerDigits = answer.getDigits();
        List<Integer> guessDigits = guess.getDigits();
        for (int i = 0; i < GameRule.DIGIT_COUNT; i++) {
            if (answerDigits.get(i).equals(guessDigits.get(i))) {
                count++;
            }
        }
        return count;
    }

    private static int countBall(BaseballNumber answer, BaseballNumber guess) {
        int count = 0;
        List<Integer> answerDigits = answer.getDigits();
        List<Integer> guessDigits = guess.getDigits();
        for (int i = 0; i < GameRule.DIGIT_COUNT; i++) {
            if (answerDigits.contains(guessDigits.get(i)) &&
                !answerDigits.get(i).equals(guessDigits.get(i))) {
                count++;
            }
        }
        return count;
    }

    public int getStrike() {
        return strike;
    }

    public int getBall() {
        return ball;
    }
}
