package level3.module.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class ArrayToStringConverterTest {

    @Test
    void 배열_변환_성공_테스트() {
        // given
        final ArrayToStringConverter arrayToStringConverter = ArrayToStringConverter.newInstance();
        final boolean[] booleans = new boolean[3];
        Arrays.fill(booleans, true);
        final String expected = """
                - 0
                - 1
                - 2
                """;
        // when
        final String result = arrayToStringConverter.booleanArrayToStringConverter(booleans);

        // then
        assertThat(result).isEqualTo(expected);
    }

}