package bridge.controller.services;

import bridge.constant.CommandTable;
import bridge.constant.GameConstant;
import bridge.model.Bridge;
import bridge.model.User;

import java.util.Objects;

public class BridgeGame {
    private final Bridge bridge;
    private final User user;

    public BridgeGame(Bridge bridge, User user) {
        this.bridge = bridge;
        this.user = user;
    }

    public boolean move(String direction) {
        if (bridge.isAccessiblePosition(user.getMovingDistance(), direction)) {
            user.markPosition(direction);
            return true;
        }
        user.markPosition(GameConstant.WRONG_DIRECTION + direction);
        return false;
    }

    public int retry(String command) {
        if (Objects.equals(command, CommandTable.RETRY.getInitial())) {
            return CommandTable.RETRY.getNumber();
        }
        return CommandTable.QUIT.getNumber();
    }
}
