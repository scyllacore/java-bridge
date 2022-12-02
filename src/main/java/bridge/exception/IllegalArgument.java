package bridge.exception;

public enum IllegalArgument {
    WRONG_INPUT("잘못된 형태의 입력입니다."),
    WRONG_VALUE("잘못된 값이 존재합니다.");

    private final String error = "[ERROR] ";

    private String message;

    IllegalArgument(String message) {
        this.message = error + message;
    }

    public static void handleException(String message) throws IllegalArgumentException {
        throw new IllegalArgumentException(message);
    }

    public String getMessage() {
        return message;
    }
}
