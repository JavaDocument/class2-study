package Hazel0c0.level1.Calculator;

import org.springframework.stereotype.Service;

public class Calculator {
  private int num1;
  private int num2;
  private int result;

  public Calculator(int num1, int num2)  {
    this.num1 = num1;
    if (num2==0){
//      throw new Exception("ERROR : num2 cannot be zero");
    } else {
      this.num2 = num2;
    }
  }

  public void add() {
    System.out.println("합 : "+(num1+num2));
  }

  public void subtract () {
    System.out.println("차 : "+(num1-num2));
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
