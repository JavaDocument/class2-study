package level3.module.domain;

import level3.module.Solution;
import level3.module.domain.input.ConsoleReader;

public class AlgorithmSolver implements Solution {
    private final ConsoleReader consoleReader;
    private final PrimeNumbersFinder primeNumbersFinder;
    private final ArrayToStringConverter arrayToStringConverter = ArrayToStringConverter.newInstance();

    private AlgorithmSolver(final ConsoleReader consoleHandler, final PrimeNumbersFinder primeNumbersFinder) {
        this.consoleReader = consoleHandler;
        this.primeNumbersFinder = primeNumbersFinder;
    }

    public static AlgorithmSolver newInstance(final ConsoleReader consoleReader, final PrimeNumbersFinder primeNumbersFinder) {
        return new AlgorithmSolver(consoleReader, primeNumbersFinder);
    }

    @Override
    public void process() {
        while (true) {
            printInputNumber();
            String inputNumber = consoleReader.read();
            if (inputNumber.equals("-1")) {
                printExitMessage();
                return;
            }
            boolean[] primeNumbers = primeNumbersFinder.getPrimesInRangeFrom(Integer.parseInt(inputNumber));

            String s = arrayToStringConverter.booleanArrayToStringConverter(primeNumbers);
            printResultMessage(s);
        }
    }

    private void printInputNumber() {
        System.out.println("== 입력 ==");
        System.out.print("숫자 입력 : ");
    }

    private void printExitMessage() {
        System.out.println("== 종료 ==");
    }

    private void printResultMessage(final String result) {
        System.out.println("== 결과 ==");
        System.out.println(result);
    }
}
