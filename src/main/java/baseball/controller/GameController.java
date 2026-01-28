package baseball.controller;

import baseball.exception.InvalidInputException;
import baseball.model.AnswerGenerator;
import baseball.model.BaseballNumber;
import baseball.model.Game;
import baseball.model.Judgement;
import baseball.view.InputView;
import baseball.view.OutputView;

public class GameController {

    private final InputView inputView;
    private final OutputView outputView;
    private final AnswerGenerator generator;

    public GameController(InputView inputView, OutputView outputView, AnswerGenerator generator) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.generator = generator;
    }

    public void run() {
        while (true) {
            playOneGame();
            if (!askRestart()) {
                return;
            }
        }
    }

    private void playOneGame() {
        Game game = new Game(generator);
        while (!game.isFinished()) {
            processOneGuess(game);
        }
        outputView.printGameEndMessage();
    }

    private void processOneGuess(Game game) {
        try {
            Judgement judgement = guess(game);
            outputView.printResult(judgement);
        } catch (InvalidInputException e) {
            outputView.printError(e.getMessage());
        }
    }

    private Judgement guess(Game game) {
        String input = inputView.readGuess();
        BaseballNumber guess = BaseballNumber.from(input);
        return game.guess(guess);
    }

    private boolean askRestart() {
        while (true) {
            String command = inputView.readRestartCommand();
            if (isRestart(command)) {
                return true;
            }
            if (isExit(command)) {
                return false;
            }
            outputView.printError("[ERROR] 1 또는 2를 입력해야 합니다.");
        }
    }

    private boolean isRestart(String command) {
        return "1".equals(command);
    }

    private boolean isExit(String command) {
        return "2".equals(command);
    }

}
