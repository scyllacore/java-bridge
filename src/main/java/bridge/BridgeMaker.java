package bridge;

import bridge.constant.DirectionTable;
import bridge.constant.GameConstant;
import bridge.controller.MapConverter;
import bridge.exception.IllegalArgument;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class BridgeMaker {
    private final BridgeNumberGenerator bridgeNumberGenerator;

    public BridgeMaker(BridgeNumberGenerator bridgeNumberGenerator) {
        this.bridgeNumberGenerator = bridgeNumberGenerator;
    }

    public List<String> makeBridge(int size) {
        validateSize(size);

        return Stream.generate(bridgeNumberGenerator::generate)
                .limit(size)
                .map(DirectionTable::getInitialFromNumber)
                .collect(Collectors.toList());
    }

    private void validateSize(int size) {
        if (size >= GameConstant.MIN_SIZE && size <= GameConstant.MAX_SIZE) {
            return;
        }
        IllegalArgument.handleException(IllegalArgument.WRONG_INPUT.getMessage());
    }
}
