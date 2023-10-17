package level1.controller;

import level1.core.Calculator;
import level1.input.ConsoleInputHandler;

public class Controller {
    private final Calculator calculator;
    private final ConsoleInputHandler consoleInputHandler;

    public Controller(final Calculator calculator, final ConsoleInputHandler consoleInputHandler) {
        this.calculator = calculator;
        this.consoleInputHandler = consoleInputHandler;
    }

    public void run() {
        final int FIRST_INPUT = 1;
        final int SECOND_INPUT = 2;
        int number1 = userInput(FIRST_INPUT);
        int number2 = userInput(SECOND_INPUT);

        calculator.process(number1, number2);
        calculator.printResult();
    }

    private int userInput(final int inputCount) {
        System.out.println(inputCount + "번째 정수입력");
        return consoleInputHandler.getNumberInput(inputCount);
    }

}
