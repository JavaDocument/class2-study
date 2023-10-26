package level1.input;

import static common.Console.readLine;

public class ConsoleInputHandler {

    public ConsoleInputHandler() {
    }

    public int getNumberInput(final int inputCount) {
        final int SECOND_INPUT = 2;

        while (true) {
            try {
                int inputNumber = readIntegerFromUserInput();
                if (inputCount == SECOND_INPUT) validateNonZeroNumber(inputNumber);

                return inputNumber;
            } catch (NumberFormatException e) {
                System.out.println("입력오류 : 정수로 입력해주세요.");
            } catch (ArithmeticException e) {
                System.out.println("입력오류 : 두번째 숫자는 0이 될 수 없습니다.");
            }
        }
    }

    private int readIntegerFromUserInput() throws NumberFormatException {
        return Integer.parseInt(readLine());
    }

    private void validateNonZeroNumber(final int inputNumber) throws ArithmeticException {
        final int ZERO = 0;
        if (inputNumber == ZERO) throw new ArithmeticException();
    }

}
