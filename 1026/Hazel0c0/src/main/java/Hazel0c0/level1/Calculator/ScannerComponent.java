package Hazel0c0.level1.Calculator;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ScannerComponent {
  private final Scanner scanner;

  public ScannerComponent() {
    this.scanner = new Scanner(System.in);
  }

  public int readInt() {
    while (true) {
      try {
        System.out.println("숫자를 입력하세요 : ");
        return scanner.nextInt();
      } catch (InputMismatchException e) {
        System.out.println("error : " + e);
      } catch (Exception e) {
        if (e.equals("ERROR : num2 cannot be zero")) {
          System.out.println("0이 아닌");
        }
        System.out.println("정수를 입력해주세요");
        System.out.println("ERROR message: " + e);
      }
    }
  }

}
