package baseball;

import baseball.controller.GameController;
import baseball.model.AnswerGenerator;
import baseball.model.RandomAnswerGenerator;
import baseball.view.InputView;
import baseball.view.OutputView;

public class App {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        AnswerGenerator generator = new RandomAnswerGenerator();

        GameController controller = new GameController(inputView, outputView, generator);
        controller.run();
    }
}
