package level3.module.config;

import level3.module.Solution;
import level3.module.domain.AlgorithmSolver;
import level3.module.domain.ArrayToStringConverter;
import level3.module.domain.PrimeNumbersFinder;
import level3.module.domain.input.ConsoleReader;

public class SolutionConfigFactory {
    private static Solution solution;
    private static AlgorithmSolver algorithmSolver;
    private static ConsoleReader consoleReader;
    private static ArrayToStringConverter arrayToStringConverter;
    private static PrimeNumbersFinder primeNumbersFinder;

    private SolutionConfigFactory() {
    }

    public static Solution createSolution() {
        if (solution == null) solution = createAlgorithmSolver();
        return solution;
    }

    private static Solution createAlgorithmSolver() {
        if (algorithmSolver == null) {
            algorithmSolver = AlgorithmSolver.newInstance(createConsoleReader(), createPrimeNumbersFinder(), createArrayToStringConverter());
        }
        return algorithmSolver;
    }

    private static ConsoleReader createConsoleReader() {
        if (consoleReader == null) {
            consoleReader = ConsoleReader.newInstance();
        }
        return consoleReader;
    }

    private static PrimeNumbersFinder createPrimeNumbersFinder() {
        if (primeNumbersFinder == null) {
            primeNumbersFinder = PrimeNumbersFinder.newInstance();
        }
        return primeNumbersFinder;
    }

    private static ArrayToStringConverter createArrayToStringConverter() {
        if (arrayToStringConverter == null) {
            arrayToStringConverter = ArrayToStringConverter.newInstance();
        }
        return arrayToStringConverter;
    }

}
