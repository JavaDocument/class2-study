package level1.core;

import java.util.LinkedList;
import java.util.Queue;

public class Calculator {

    private final Queue<String> result = new LinkedList<>();

    public void process(final int number1, final int number2) {
        result.add("== 결과 ==");
        result.add("- 입력한 숫자 : [" + number1 + ", " + number2 + "]");
        result.add("- 합 : [" + (number1 + number2) + "]");
        result.add("- 차 : [" + (number1 - number2) + "]");
        result.add("- 곱 : [" + (number1 * number2) + "]");
        result.add("- 나눈 몫 : [" + (number1 / number2) + "]");
        result.add("- 나눈 나머지 : [" + (number1 % number2) + "]");
    }

    public void printResult() {
        Queue<String> result = new LinkedList<>(this.result);

        while (!result.isEmpty()) {
            System.out.println(result.poll());
        }
    }

}
