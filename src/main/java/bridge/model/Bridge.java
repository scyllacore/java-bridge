package bridge.model;

import java.util.List;

public class Bridge {
    private final List<String> bridgeMap;

    public Bridge(List<String> bridge) {
        this.bridgeMap = bridge;
    }

    public boolean isAccessiblePosition(int distance, String direction) {
        return bridgeMap.get(distance).equals(direction);
    }

    public boolean isUnderBridgeSize(int userDistance) {
        return userDistance < bridgeMap.size();
    }
}
