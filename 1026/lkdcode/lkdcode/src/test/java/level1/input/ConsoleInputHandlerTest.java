package level1.input;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.assertj.core.api.Assertions.assertThat;

class ConsoleInputHandlerTest {
    private final int FIRST_INPUT_COUNT = 1;
    private final int SECOND_INPUT_COUNT = 2;

    @Test
    @DisplayName("콘솔 입력에 성공할 것이다.")
    public void consoleInputHandlerTest1() {
        // given
        String simulatedInput = "123";
        InputStream inputStream = new ByteArrayInputStream(simulatedInput.getBytes());
        System.setIn(inputStream);
        ConsoleInputHandler consoleInputHandler = new ConsoleInputHandler();

        // when
        int numberInput = consoleInputHandler.getNumberInput(FIRST_INPUT_COUNT);


        // then
        assertThat(Integer.parseInt(simulatedInput)).isEqualTo(numberInput);
    }

}