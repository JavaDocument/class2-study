package level2.controller;

import level2.core.PrimeNumber;
import level2.input.ConsoleInputHandler;
import level2.output.Print;

public class Controller {
    private final ConsoleInputHandler consoleInputHandler;
    private final Print print;

    public Controller(final ConsoleInputHandler consoleInputHandler, final Print print) {
        this.consoleInputHandler = consoleInputHandler;
        this.print = print;
    }

    public void run() {
        System.out.println("== 입력 ==");
        final int number = consoleInputHandler.readNumber();
        final boolean[] primeNumbers = PrimeNumber.valueOf(number);
        print.printResult(primeNumbers);
    }

}
