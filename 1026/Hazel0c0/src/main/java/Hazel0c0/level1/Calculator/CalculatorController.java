package Hazel0c0.level1.Calculator;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

//@Component
public class CalculatorController implements CommandLineRunner {
//public class CalculatorController {
  private final CalculatorService cs;

  public CalculatorController(CalculatorService cs) {
    this.cs = cs;
  }

  @Override
  public void run(String... args) throws Exception {
    System.out.println("controller start");
    cs.allCalculated();
  }
}
