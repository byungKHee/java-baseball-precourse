package baseball.model;

/**
 * 게임의 규칙을 정의하는 클래스입니다.
 * DIGIT_COUNT: 게임에서 사용되는 숫자의 개수
 * MIN_NUMBER: 게임에서 사용되는 숫자의 최소 숫자
 * MAX_NUMBER: 게임에서 사용되는 숫자의 최대 숫자
 */
public class GameRule {
    public static final int DIGIT_COUNT = 3;
    public static final int MIN_NUMBER = 1;
    public static final int MAX_NUMBER = 9;

    private GameRule() {}
}
