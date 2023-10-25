package level3;

import level3.module.Solution;
import level3.module.config.SolutionConfigFactory;

public class Application {
    public static void main(String[] args) {
        final Solution solution = SolutionConfigFactory.createSolution();
        solution.process();
    }

}
