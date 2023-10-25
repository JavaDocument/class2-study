package level3.module.domain;

import level3.module.Solution;
import level3.module.domain.input.ConsoleReader;

public class AlgorithmSolver implements Solution {
    private final ConsoleReader consoleReader;
    private final PrimeNumbersFinder primeNumbersFinder;
    private final ArrayToStringConverter arrayToStringConverter;

    private AlgorithmSolver(final ConsoleReader consoleHandler, final PrimeNumbersFinder primeNumbersFinder, final ArrayToStringConverter arrayToStringConverter) {
        this.consoleReader = consoleHandler;
        this.primeNumbersFinder = primeNumbersFinder;
        this.arrayToStringConverter = arrayToStringConverter;
    }

    public static AlgorithmSolver newInstance(final ConsoleReader consoleReader, final PrimeNumbersFinder primeNumbersFinder, final ArrayToStringConverter arrayToStringConverter) {
        return new AlgorithmSolver(consoleReader, primeNumbersFinder, arrayToStringConverter);
    }

    @Override
    public void process() {
        final String EXIT_COMMAND = "-1";
        while (true) {
            printInputNumber();
            final String inputNumber = consoleReader.read();
            if (inputNumber.equals(EXIT_COMMAND)) {
                printExitMessage();
                return;
            }
            final boolean[] primeNumbers = primeNumbersFinder.getPrimesInRangeFrom(Integer.parseInt(inputNumber));

            String result = arrayToStringConverter.booleanArrayToStringConverter(primeNumbers);
            printResultMessage(result);
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
