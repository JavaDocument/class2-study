package level3.domain.input;

import java.util.Scanner;

public class ConsoleInputHandler {
    private final Scanner scanner = new Scanner(System.in);

    public int readNumber() {
        while (true) {
            try {
                System.out.print("숫자 입력 : ");
                int inputNumber = Integer.parseInt(scanner.nextLine());
                validatePositiveNumber(inputNumber);
                return inputNumber;
            } catch (NumberFormatException e) {
                System.out.println("입력오류 : 정수로 입력해주세요.");
            } catch (IllegalArgumentException e) {
                System.out.println("입력오류 : 2 이상의 숫자를 입력해주세요.");
                System.out.println("입력오류 : 종료는 -1 을 입력해주세요.");
            }
        }
    }

    private void validatePositiveNumber(final int number) throws IllegalStateException {
        if (number < 2 && number != -1) throw new IllegalArgumentException();
    }

}
