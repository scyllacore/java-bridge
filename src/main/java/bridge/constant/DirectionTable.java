package bridge.constant;

public enum DirectionTable {
    DOWN("D", "O", 0),
    UP("U", "O", 1),
    NOT_DOWN("ND", "X", 0),
    NOT_UP("NU", "X", 1);

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
}

