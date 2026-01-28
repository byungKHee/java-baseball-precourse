package baseball.model;

public class Game {

    private final BaseballNumber answer;
    private boolean finished;

    public Game(AnswerGenerator generator) {
        this.answer = generator.generate();
        this.finished = false;
    }

    public Judgement guess(BaseballNumber guess) {
        Judgement judgement = Judgement.of(answer, guess);
        finishIfCorrect(judgement);
        return judgement;
    }

    public boolean isFinished() {
        return finished;
    }

    private void finishIfCorrect(Judgement judgement) {
        if (!isCorrect(judgement)) {
            return;
        }
        finished = true;
    }

    private boolean isCorrect(Judgement judgement) {
        return judgement.getStrike() == GameRule.DIGIT_COUNT;
    }
}
