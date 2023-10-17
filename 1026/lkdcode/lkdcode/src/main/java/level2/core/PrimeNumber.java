package level2.core;

import java.util.Arrays;

public class PrimeNumber {

    private PrimeNumber() {
    }

    public static boolean[] valueOf(final int number) {
        boolean[] list = new boolean[number + 1];

        initial(list);
        calculate(list);

        return list;
    }

    private static void initial(final boolean[] list) {
        Arrays.fill(list, true);
        list[0] = false;
        list[1] = false;
    }

    private static void calculate(final boolean[] list) {
        for (int i = 2; i < list.length; i++) {
            for (int j = i + i; j < list.length; j += i) {
                list[j] = false;
            }
        }
    }

}
