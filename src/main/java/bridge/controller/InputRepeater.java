package bridge.controller;

import bridge.view.OutputView;

import java.util.function.Supplier;

public class InputRepeater {
    public static <T> T repeat(Supplier<T> inputReader) {
        for (; ; ) {
            try {
                return inputReader.get();
            } catch (IllegalArgumentException error) {
                OutputView.printErrorMessage(error.getMessage());
            }
        }
    }
}
