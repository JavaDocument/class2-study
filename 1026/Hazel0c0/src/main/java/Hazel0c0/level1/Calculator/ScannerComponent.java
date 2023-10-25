package Hazel0c0.level1.Calculator;

import java.util.Scanner;

public class ScannerComponent {
  private final Scanner scanner;

  public ScannerComponent() {
    this.scanner = new Scanner(System.in);
  }

  public int readInt(){
    System.out.println("숫자를 입력하세요 : ");
    return scanner.nextInt();
  }

}
