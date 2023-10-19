package level2.config;

import level2.controller.Controller;
import level2.input.ConsoleInputHandler;
import level2.output.Print;

public class AppConfig {

    private AppConfig() {
    }

    public static Controller generateController() {
        return new Controller(generateConsoleInputHandler(), generatePrint());
    }

    public static ConsoleInputHandler generateConsoleInputHandler() {
        return new ConsoleInputHandler();
    }

    public static Print generatePrint() {
        return new Print();
    }

}
