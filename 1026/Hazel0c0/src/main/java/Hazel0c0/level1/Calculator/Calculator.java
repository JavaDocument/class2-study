package Hazel0c0.level1.Calculator;

import org.springframework.stereotype.Service;

//@Service
public class Calculator {
  int num1;
  int num2;

  public Calculator(int num1, int num2) {
    this.num1 = num1;
    this.num2 = num2;
  }

  public int add() {
    System.out.println("합 : "+(num1+num2));
    return num1+num2;
  }

  public int subtract() {
    System.out.println("차 : "+(num1-num2));
    return num1-num2;
  }

  public int multiply() {
    System.out.println("곱 = " + (num1 * num2));
    return num1*num2;
  }

  public int divide() {
    System.out.println("나눈 몫 = " + (num1 / num2));
   return num1/num2;
  }
  public int share() {
    System.out.println("나눈 나머지 = " + (num1 % num2));
    return num1%num2;
  }
}
