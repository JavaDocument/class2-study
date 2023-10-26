package Hazel0c0.level1.calculator;

import java.util.InputMismatchException;

public class Calculator {
  private int num1;
  private int num2;

  public Calculator(ScannerComponent sc) {
    this.num1 = sc.readInt();
    while (num2 == 0) {
      try {
        this.num2 = sc.readInt();
        if (num2==0) throw new InputMismatchException("ERROR : num2 cannot be zero");
      } catch (InputMismatchException e) {
        System.out.println("0이 아닌 숫자를 입력해주세요");
      }
    }
  }

  public void add() {
    System.out.println("합 : " + (num1 + num2));
  }

  public void subtract() {
    System.out.println("차 : " + (num1 - num2));
  }

  public void multiply() {
    System.out.println("곱 = " + (num1 * num2));
  }

  public void divide() {
    System.out.println("나눈 몫 = " + (num1 / num2));
  }

  public void share() {
    System.out.println("나눈 나머지 = " + (num1 % num2));
  }
}
