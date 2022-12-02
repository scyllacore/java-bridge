package bridge.view;


import bridge.constant.GameConstant;
import bridge.controller.GameResult;
import bridge.controller.MapConverter;

public class OutputView {
    private static final String START_CHARACTER = "[";
    private static final String END_CHARACTER = "]";
    private static final String DELIMITER = "|";
    private static final String RESULT_MESSAGE = "최종 게임 결과";
    private static final String PASS_FAIL_MESSAGE = "게임 성공 여부:";
    private static final String ATTEMPT_COUNT_MESSAGE = "총 시도한 횟수:";
    private static final String RUN_GAME_MESSAGE = "다리 건너기 게임을 시작합니다.";
    private static final String EXCEEDED_ATTEMPT_MESSAGE = "가능한 시도 횟수를 초과하여 게임을 종료합니다.";

    public static void printRunGameMessage() {
        System.out.println(RUN_GAME_MESSAGE);
        System.out.println("");
    }

    public static void printResult(GameResult gameResult) {
        printExceededAttempt(gameResult.getResultNumber());
        printResultMessage();
        printMap(MapConverter.convertMap(gameResult.getUser().getUserMap()));
        printPassFailMessage(gameResult);
        printAttemptCountMessage(gameResult);
    }

    public static void printMap(String[][] detailedMap) {
        int length = detailedMap[0].length;

        for (int row = GameConstant.BRIDGE_WIDTH - 1; row >= 0; row--) {
            System.out.print(String.format("%s ", START_CHARACTER));
            for (int column = 0; column < length - 1; column++) {
                System.out.print(String.format("%s %s ", detailedMap[row][column], DELIMITER));
            }
            System.out.println(String.format("%s %s", detailedMap[row][length - 1], END_CHARACTER));
        }
        System.out.println("");
    }

    private static void printExceededAttempt(int resultNumber) {
        if (resultNumber == GameResult.FAIL) {
            System.out.println(EXCEEDED_ATTEMPT_MESSAGE);
        }
    }

    private static void printResultMessage() {
        System.out.println(RESULT_MESSAGE);
    }

    private static void printPassFailMessage(GameResult gameResult) {
        System.out.println(String.format("%s %s", PASS_FAIL_MESSAGE, gameResult.getPassFailMessage()));
    }

    private static void printAttemptCountMessage(GameResult gameResult) {
        System.out.println(String.format("%s %d", ATTEMPT_COUNT_MESSAGE, gameResult.getAttemptCount()));
    }

    public static void printErrorMessage(String message) {
        System.out.println(message);
    }
}
