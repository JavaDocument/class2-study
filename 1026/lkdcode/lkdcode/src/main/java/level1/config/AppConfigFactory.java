package level1.config;

import level1.controller.Controller;
import level1.core.Calculator;
import level1.input.ConsoleInputHandler;

public class AppConfigFactory {
    private static Controller controller;
    private static Calculator calculator;
    private static ConsoleInputHandler consoleInputHandler;

    private AppConfigFactory() {
    }

    public static Controller generateController() {
        if (controller == null) controller = new Controller(generateCalculator(), generateConsoleInputHandler());
        return controller;
    }

    private static Calculator generateCalculator() {
        if (calculator == null) calculator = new Calculator();
        return calculator;
    }

    private static ConsoleInputHandler generateConsoleInputHandler() {
        if (consoleInputHandler == null) consoleInputHandler = new ConsoleInputHandler();
        return consoleInputHandler;
    }

}
