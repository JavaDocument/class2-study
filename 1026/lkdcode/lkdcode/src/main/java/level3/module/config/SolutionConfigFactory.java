package level3.module.config;

import level3.module.Solution;
import level3.module.domain.AlgorithmSolver;
import level3.module.domain.PrimeNumbersFinder;
import level3.module.domain.input.ConsoleReader;

public class SolutionConfigFactory {
    private static Solution solution;
    private static AlgorithmSolver primeNumbersFinder;
    private static ConsoleReader consoleReader;

    private SolutionConfigFactory() {
    }

    public static Solution createSolution() {
        if (solution == null) solution = createAlgorithmSolver();
        return solution;
    }

    private static Solution createAlgorithmSolver() {
        if (primeNumbersFinder == null) {
            primeNumbersFinder = AlgorithmSolver.newInstance(createConsoleReader(), createPrimeNumbersFinder());
        }
        return primeNumbersFinder;
    }

    private static ConsoleReader createConsoleReader() {
        if (consoleReader == null) {
            consoleReader = ConsoleReader.newInstance();
        }
        return consoleReader;
    }

    private static PrimeNumbersFinder createPrimeNumbersFinder() {
        return PrimeNumbersFinder.newInstance();
    }

}
