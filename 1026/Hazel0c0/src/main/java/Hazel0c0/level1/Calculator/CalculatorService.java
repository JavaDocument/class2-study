package Hazel0c0.level1.Calculator;

import org.springframework.stereotype.Service;

public class CalculatorService {
  private Calculator cal;
  private ScannerComponent sc=new ScannerComponent();

  public void run()  {
    int num1 = sc.readInt();
    int num2 = sc.readInt();

    cal=new Calculator(num1,num2);
    cal.add();
    cal.subtract();
    cal.multiply();
    cal.divide();
    cal.share();
  }
}
