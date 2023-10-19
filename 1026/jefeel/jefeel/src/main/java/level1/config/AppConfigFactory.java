package level1.config;

import level1.controller.Controller;
import level1.core.Calculator;
import level1.input.ConsoleInputHandler;

public class AppConfigFactory {

    private AppConfigFactory() {
    }

    public static Controller generateController() {
        return new Controller(generateCalculator(), generateConsoleInputHandler());
    }

    public static Calculator generateCalculator() {
        return new Calculator();
    }

    public static ConsoleInputHandler generateConsoleInputHandler() {
        return new ConsoleInputHandler();
    }
}
