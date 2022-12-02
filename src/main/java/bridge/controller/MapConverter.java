package bridge.controller;

import bridge.constant.DirectionTable;
import bridge.constant.GameConstant;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class MapConverter {
    private static final Map<String, String> TableAccessor = Map.of(
            DirectionTable.DOWN.getInitial(), DirectionTable.DOWN.name(),
            DirectionTable.UP.getInitial(), DirectionTable.UP.name(),
            DirectionTable.NOT_DOWN.getInitial(), DirectionTable.NOT_DOWN.name(),
            DirectionTable.NOT_UP.getInitial(), DirectionTable.NOT_UP.name()
    );

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
            DirectionTable directionData = DirectionTable.valueOf(TableAccessor.get(map.get(column)));
            detailedMap[directionData.getDirection()][column] = directionData.getCondition();
        }
    }

    public static String getDirection(int number) {
        if (number == DirectionTable.DOWN.getDirection()) {
            return DirectionTable.DOWN.getInitial();
        }
        return DirectionTable.UP.getInitial();
    }
}
