package level3.module.config;

import level3.module.Solution;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class SolutionConfigFactoryTest {

    @Test
    void 단_하나의_인스턴스만_생성할_것이다() {
        // given
        Solution solution1 = SolutionConfigFactory.createSolution();
        Solution solution2 = SolutionConfigFactory.createSolution();
        Solution solution3 = SolutionConfigFactory.createSolution();
        Solution solution4 = SolutionConfigFactory.createSolution();

        // when & then
        Assertions.assertThat(solution1)
                .isSameAs(solution2)
                .isSameAs(solution3)
                .isSameAs(solution4);
    }

}