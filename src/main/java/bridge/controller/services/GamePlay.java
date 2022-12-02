package bridge.controller.services;

import bridge.constant.CommandTable;
import bridge.constant.GameConstant;
import bridge.controller.GameResult;
import bridge.controller.InputRepeater;
import bridge.controller.MapConverter;
import bridge.model.Bridge;
import bridge.model.User;
import bridge.view.InputView;
import bridge.view.OutputView;

public class GamePlay {
    private final Bridge bridge;
    private User user;

    public GamePlay(Bridge bridge) {
        this.bridge = bridge;
    }

    public GameResult playGame() {
        for (int attemptCount = 1; attemptCount <= GameConstant.MAX_ATTEMPT_COUNT; attemptCount++) {
            int resultNumber = tryGameOnce();

            if (isNotRetry(resultNumber)) {
                return new GameResult(user, resultNumber, attemptCount);
            }
        }
        return new GameResult(user, GameResult.FAIL, GameConstant.MAX_ATTEMPT_COUNT);
    }

    private boolean isNotRetry(int result) {
        return result != CommandTable.RETRY.getNumber();
    }

    private int tryGameOnce() {
        BridgeGame bridgeGame = loadBridgeGame();

        for (; bridge.isUnderBridgeSize(user.getMovingDistance()); ) {
            if (isGameOver(tryMove(bridgeGame))) {
                return selectMenu(bridgeGame);
            }
        }
        return GameResult.PASS;
    }

    private boolean isGameOver(boolean result) {
        return result == false;
    }

    private BridgeGame loadBridgeGame() {
        user = new User();
        return new BridgeGame(bridge, user);
    }

    private boolean tryMove(BridgeGame bridgeGame) {
        boolean movingResult = bridgeGame.move(InputRepeater.repeat(InputView::readMoving));
        printProgress();
        return movingResult;
    }

    private void printProgress() {
        OutputView.printMap(MapConverter.convertMap(user.getUserMap()));
    }

    private int selectMenu(BridgeGame bridgeGame) {
        return bridgeGame.retry(InputRepeater.repeat(InputView::readGameCommand));
    }
}
