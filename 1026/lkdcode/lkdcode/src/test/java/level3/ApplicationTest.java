package level3;

import level3.module.Solution;
import level3.module.config.SolutionConfigFactory;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;

class ApplicationTest {

    @Test
    void 소수_리스트_통합_테스트() {
        // given
        final String[] e = {"== 입력 ==", "== 결과 ==", "== 종료 ==", "숫자 입력 : ",
                "- 2", "- 3", "- 5", "- 7"};

        final String inputNumber = "10\n-1";
        System.setIn(new ByteArrayInputStream(inputNumber.getBytes()));
        final OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        // when
        final Solution solution = SolutionConfigFactory.createSolution();
        solution.process();

        // then
        Assertions.assertThat(out.toString()).contains(e);
    }

}