package bridge.controller;

import bridge.constant.DirectionTable;
import bridge.constant.GameConstant;

import java.util.Arrays;
import java.util.List;

public class MapConverter {
    public static String[][] convertMap(List<String> map) {
        String[][] detailedMap = new String[GameConstant.BRIDGE_WIDTH][map.size()];
        initializeDetailedMap(detailedMap);
        makeDetailMap(detailedMap, map);
        return detailedMap;
    }

    private static void initializeDetailedMap(String[][] detailedMap) {
        for (int row = 0; row < GameConstant.BRIDGE_WIDTH; row++) {
            Arrays.fill(detailedMap[row], " ");
        }
    }

    private static void makeDetailMap(String[][] detailedMap, List<String> map) {
        for (int column = 0; column < map.size(); column++) {
            DirectionTable directionData = DirectionTable.getValueFromInitial(map.get(column));
            detailedMap[directionData.getDirection()][column] = directionData.getCondition();
        }
    }
}
