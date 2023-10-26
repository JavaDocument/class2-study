package Hazel0c0.level1;

import Hazel0c0.level1.calculator.CalculatorService;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CalculatorApp {

	public static void main(String[] args)  {
		CalculatorService cc=new CalculatorService();
		cc.run();
	}

}
