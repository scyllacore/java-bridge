package bridge.view.valueobject;

import bridge.exception.IllegalArgument;

import java.util.regex.Pattern;

public class Size {
    private static final Pattern sizePattern = Pattern.compile("^\\d{1,2}$");

    private final String size;

    public Size(String size) {
        validateSize(size);
        this.size = size;
    }

    private void validateSize(String size) {
        if (sizePattern.matcher(size).matches()) {
            return;
        }
        IllegalArgument.handleException(IllegalArgument.WRONG_INPUT.getMessage());
    }

    public String getSize() {
        return size;
    }
}
