package level3.domain.core;

import java.util.Arrays;

public class PrimeNumbers {
    private static boolean[] list;

    private PrimeNumbers() {
    }

    public static boolean[] valueOf(final int number) {
        final int newSize = number + 1;

        if (list == null || list.length < newSize) {
            initializeAndCalculate(newSize);
        }

        return list;
    }

    private static void initializeAndCalculate(final int size) {
//        System.out.println("== 소수 배열 초기화 ==");
        list = new boolean[size];
        initial();
        calculate();
    }

    private static void initial() {
        Arrays.fill(list, true);
        list[0] = false;
        list[1] = false;
    }

    private static void calculate() {
        for (int i = 2; i < list.length; i++) {
            for (int j = i + i; j < list.length; j += i) {
                list[j] = false;
            }
        }
    }

}
