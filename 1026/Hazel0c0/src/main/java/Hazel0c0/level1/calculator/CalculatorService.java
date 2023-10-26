package Hazel0c0.level1.calculator;


public class CalculatorService {
  private Calculator cal;
  private ScannerComponent sc=new ScannerComponent();

  public void run()  {
    cal=new Calculator(sc);
    cal.add();
    cal.subtract();
    cal.multiply();
    cal.divide();
    cal.share();
  }
}
