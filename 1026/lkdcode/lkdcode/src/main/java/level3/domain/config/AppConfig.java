package level3.domain.config;

import level3.domain.controller.Controller;
import level3.domain.input.ConsoleInputHandler;
import level3.domain.output.Print;

public class AppConfig {

    private AppConfig() {
    }

    public static Controller generateController() {
        return new Controller(generateConsoleInputHandler(), generatePrint());
    }

    private static ConsoleInputHandler generateConsoleInputHandler() {
        return new ConsoleInputHandler();
    }

    private static Print generatePrint() {
        return new Print();
    }

}
