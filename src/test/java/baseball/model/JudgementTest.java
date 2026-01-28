package baseball.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JudgementTest {

    @Test
    @DisplayName("같은 숫자가 같은 자리에 있으면 스트라이크로 판정한다")
    void countStrike_onlyStrike() {
        // given
        BaseballNumber answer = BaseballNumber.from("425");
        BaseballNumber guess = BaseballNumber.from("423");

        // when
        Judgement judgement = Judgement.of(answer, guess);

        // then
        assertEquals(2, judgement.getStrike());
        assertEquals(0, judgement.getBall());
    }

    @Test
    @DisplayName("같은 숫자가 다른 자리에 있으면 볼로 판정한다")
    void countBall_onlyBall() {
        // given
        BaseballNumber answer = BaseballNumber.from("425");
        BaseballNumber guess = BaseballNumber.from("542");

        // when
        Judgement judgement = Judgement.of(answer, guess);

        // then
        assertEquals(0, judgement.getStrike());
        assertEquals(3, judgement.getBall());
    }

    @Test
    @DisplayName("스트라이크와 볼이 섞여있는 경우도 올바르게 판정한다")
    void countStrikeAndBall() {
        // given
        BaseballNumber answer = BaseballNumber.from("425");
        BaseballNumber guess = BaseballNumber.from("452");

        // when
        Judgement judgement = Judgement.of(answer, guess);

        // then
        assertEquals(1, judgement.getStrike());
        assertEquals(2, judgement.getBall());
    }

    @Test
    @DisplayName("스트라이크와 볼이 없는 경우도 올바르게 판정한다")
    void countNothing() {
        // given
        BaseballNumber answer = BaseballNumber.from("425");
        BaseballNumber guess = BaseballNumber.from("367");

        // when
        Judgement judgement = Judgement.of(answer, guess);

        // then
        assertEquals(0, judgement.getStrike());
        assertEquals(0, judgement.getBall());
    }

    @Test
    @DisplayName("모든 숫자가 일치하는 경우 3 스트라이크로 판정한다")
    void countAllStrike() {
        // given
        BaseballNumber answer = BaseballNumber.from("425");
        BaseballNumber guess = BaseballNumber.from("425");

        // when
        Judgement judgement = Judgement.of(answer, guess);

        // then
        assertEquals(3, judgement.getStrike());
        assertEquals(0, judgement.getBall());
    }
}
