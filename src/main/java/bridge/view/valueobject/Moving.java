package bridge.view.valueobject;

import bridge.exception.IllegalArgument;

import java.util.regex.Pattern;

public class Moving {
    private static final Pattern movingPattern = Pattern.compile("^[UD]$");

    private final String moving;

    public Moving(String moving) {
        validateMoving(moving);
        this.moving = moving;
    }

    private void validateMoving(String moving) {
        if (movingPattern.matcher(moving).matches()) {
            return;
        }
        IllegalArgument.handleException(IllegalArgument.WRONG_INPUT.getMessage());
    }

    public String getMoving() {
        return moving;
    }
}
