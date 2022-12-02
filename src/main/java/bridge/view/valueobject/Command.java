package bridge.view.valueobject;

import bridge.exception.IllegalArgument;

import java.util.regex.Pattern;

public class Command {
    private static final Pattern commandPattern = Pattern.compile("^[RQ]$");

    private final String command;

    public Command(String command) {
        validateCommand(command);
        this.command = command;
    }

    private void validateCommand(String command) {
        if (commandPattern.matcher(command).matches()) {
            return;
        }
        IllegalArgument.handleException(IllegalArgument.WRONG_INPUT.getMessage());
    }

    public String getCommand() {
        return command;
    }
}
