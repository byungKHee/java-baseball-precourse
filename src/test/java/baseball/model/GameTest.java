package baseball.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {

    @Test
    void correctGuess_finishesGame() {
        // given
        AnswerGenerator generator = new FixedAnswerGenerator("425");
        Game game = new Game(generator);

        // when
        Judgement judgement = game.guess(BaseballNumber.from("425"));

        // then
        assertTrue(game.isFinished());
        assertEquals(GameRule.DIGIT_COUNT, judgement.getStrike());
        assertEquals(0, judgement.getBall());
    }

    @Test
    void wrongGuess_doesNotFinishGame() {
        // given
        AnswerGenerator generator = new FixedAnswerGenerator("425");
        Game game = new Game(generator);

        // when
        Judgement judgement = game.guess(BaseballNumber.from("123"));

        // then
        assertFalse(game.isFinished());
        assertNotEquals(GameRule.DIGIT_COUNT, judgement.getStrike());
    }


    // 고정된 답안을 생성하는 AnswerGenerator 구현체
    private static class FixedAnswerGenerator implements AnswerGenerator {
        private final String answer;

        private FixedAnswerGenerator(String answer) {
            this.answer = answer;
        }

        @Override
        public BaseballNumber generate() {
            return BaseballNumber.from(answer);
        }
    }
}