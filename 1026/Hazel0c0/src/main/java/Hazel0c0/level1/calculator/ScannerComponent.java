package Hazel0c0.level1.calculator;

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
      } catch (InputMismatchException  e) {
        scanner.next();
        System.out.print("정수인 ");
      }
    }
  }

}
