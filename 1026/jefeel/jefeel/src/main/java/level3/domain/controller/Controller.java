package level3.domain.controller;

import level3.domain.core.PrimeNumbers;
import level3.domain.input.ConsoleInputHandler;
import level3.domain.output.Print;

public class Controller {
    private final ConsoleInputHandler consoleInputHandler;
    private final Print print;

    public Controller(final ConsoleInputHandler consoleInputHandler, final Print print) {
        this.consoleInputHandler = consoleInputHandler;
        this.print = print;
    }

    public void run() {
        while (true) {
            System.out.println("== 입력 ==");
            int number = consoleInputHandler.readNumber();
            if (number == -1) {
                System.out.println("== 종료 ==");
                return;
            }
            boolean[] primeNumbers = PrimeNumbers.valueOf(number);
            print.printResult(primeNumbers);
        }
    }

}
