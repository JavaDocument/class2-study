package Hazel0c0.level1.Calculator;

import org.springframework.stereotype.Service;

//@Service
public class CalculatorService {
  private final Calculator cal;
  private final ScannerComponent sc;

  public CalculatorService(Calculator cal, ScannerComponent sc) {
    this.cal = cal;
    this.sc = sc;
  }
  public void allCalculated(){
    int num1 = sc.readInt();
    int num2 = sc.readInt();

    new Calculator(num1,num2);
    cal.add();
    cal.subtract();
    cal.multiply();
    cal.divide();
    cal.share();
  }
}
