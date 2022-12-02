package bridge.view;

import bridge.view.valueobject.Command;
import bridge.view.valueobject.Moving;
import bridge.view.valueobject.Size;
import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final String READ_BRIDGE_SIZE_MESSAGE = "다리의 길이를 입력해주세요.";
    private static final String READ_MOVING_MESSAGE = "이동할 칸을 선택해주세요. (위: U, 아래: D)";
    private static final String READ_GAME_COMMAND_MESSAGE = "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)";

    public static String readBridgeSize() {
        printReadBridgeSizeMessage();
        return new Size(input()).getSize();
    }

    private static void printReadBridgeSizeMessage() {
        System.out.println(READ_BRIDGE_SIZE_MESSAGE);
    }

    public static String readMoving() {
        printReadMovingMessage();
        return new Moving(input()).getMoving();
    }

    private static void printReadMovingMessage() {
        System.out.println(READ_MOVING_MESSAGE);
    }

    public static String readGameCommand() {
        printReadGameCommandMessage();
        return new Command(input()).getCommand();
    }

    private static void printReadGameCommandMessage() {
        System.out.println(READ_GAME_COMMAND_MESSAGE);
    }

    public static String input() {
        return Console.readLine();
    }
}
