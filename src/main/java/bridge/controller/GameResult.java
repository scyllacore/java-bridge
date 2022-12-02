package bridge.controller;

import bridge.model.User;

public class GameResult {
    public static final int PASS = 1;
    public static final int FAIL = -2;

    private final User user;
    private final int resultNumber;
    private final int attemptCount;

    public GameResult(User user, int resultNumber, int attemptCount) {
        this.user = user;
        this.resultNumber = resultNumber;
        this.attemptCount = attemptCount;
    }

    public User getUser() {
        return user;
    }

    public int getResultNumber() {
        return resultNumber;
    }

    public String getPassFailMessage() {
        if(resultNumber == PASS){
            return "성공";
        }
        return "실패";
    }

    public int getAttemptCount() {
        return attemptCount;
    }
}
