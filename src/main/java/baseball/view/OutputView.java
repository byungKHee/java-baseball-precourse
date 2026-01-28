package baseball.view;

import baseball.model.Judgement;

public class OutputView {

//    public void printStartMessage() {
//        System.out.println("숫자 야구 게임을 시작합니다.");
//    }

    public void printResult(Judgement judgement) {
        if (isNothing(judgement)) {
            System.out.println("낫싱");
            return;
        }

        printStrike(judgement);
        printBall(judgement);
        System.out.println();
    }

    public void printGameEndMessage() {
        System.out.println("3스트라이크");
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 끝");
    }

    private boolean isNothing(Judgement judgement) {
        return judgement.getStrike() == 0 && judgement.getBall() == 0;
    }

    private void printStrike(Judgement judgement) {
        if (judgement.getStrike() == 0) {
            return;
        }
        System.out.print(judgement.getStrike() + "스트라이크");
        System.out.print(" ");
    }

    private void printBall(Judgement judgement) {
        if (judgement.getBall() == 0) {
            return;
        }
        System.out.print(judgement.getBall() + "볼");
    }
}
