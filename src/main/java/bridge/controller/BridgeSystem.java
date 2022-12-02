package bridge.controller;

import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.controller.services.GamePlay;
import bridge.model.Bridge;
import bridge.view.InputView;
import bridge.view.OutputView;

import java.util.List;

public class BridgeSystem {
    private GamePlay gamePlay;
    private GameResult gameResult;

    public void runGame() {
        OutputView.printRunGameMessage();
        gamePlay = new GamePlay(InputRepeater.repeat(this::initializeBridge));

        GameResult gameResult = gamePlay.playGame();
        OutputView.printResult(gameResult);
    }

    private Bridge initializeBridge() {
        int bridgeSize = Integer.parseInt(InputView.readBridgeSize());
        List<String> bridge = new BridgeMaker(new BridgeRandomNumberGenerator()).makeBridge(bridgeSize);
        return new Bridge(bridge);
    }
}
