package bridge.constant;

import java.util.Map;

public enum DirectionTable {
    DOWN("D", "O", 0),
    UP("U", "O", 1),
    NOT_DOWN("ND", "X", 0),
    NOT_UP("NU", "X", 1);

    private static final Map<String, String> TableAccessor = Map.of(
            DirectionTable.DOWN.getInitial(), DirectionTable.DOWN.name(),
            DirectionTable.UP.getInitial(), DirectionTable.UP.name(),
            DirectionTable.NOT_DOWN.getInitial(), DirectionTable.NOT_DOWN.name(),
            DirectionTable.NOT_UP.getInitial(), DirectionTable.NOT_UP.name()
    );

    private String initial;
    private String condition;
    private int direction;

    DirectionTable(String initial, String condition, int direction) {
        this.initial = initial;
        this.condition = condition;
        this.direction = direction;
    }

    public String getInitial() {
        return initial;
    }

    public String getCondition() {
        return condition;
    }

    public int getDirection() {
        return direction;
    }

    public static DirectionTable getValueFromInitial(String initial) {
        return valueOf(TableAccessor.get(initial));
    }

    public static String getInitialFromNumber(int number) {
        if (number == DOWN.getDirection()) {
            return DOWN.getInitial();
        }
        return UP.getInitial();
    }
}

