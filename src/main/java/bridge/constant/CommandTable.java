package bridge.constant;

public enum CommandTable {
    RETRY("R", 0),
    QUIT("Q", -1);

    private String initial;
    private int number;

    CommandTable(String initial, int number) {
        this.initial = initial;
        this.number = number;
    }

    public String getInitial() {
        return initial;
    }

    public int getNumber() {
        return number;
    }
}
