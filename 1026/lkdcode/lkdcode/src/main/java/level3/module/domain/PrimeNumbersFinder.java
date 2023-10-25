package level3.module.domain;

import java.util.Arrays;

public class PrimeNumbersFinder {

    private boolean[] isPrime;

    private PrimeNumbersFinder() {
        this.isPrime = initializePrimeNumbers();
    }

    public static PrimeNumbersFinder newInstance() {
        return new PrimeNumbersFinder();
    }

    public boolean[] getPrimesInRangeFrom(final int number) {
        final int currentSize = isPrime.length;
        final int endSize = number + 1;
        if (currentSize <= endSize) {
            expandSize(endSize);
        }
        calculatePrimeNumbers(currentSize, endSize);
        return Arrays.copyOf(isPrime, endSize);
    }

    private void calculatePrimeNumbers(final int startNumber, final int endSize) {
        for (int i = startNumber; i < endSize; i++) {
            for (int j = i + i; j < endSize; j += i) {
                isPrime[j] = false;
            }
        }
    }

    private void expandSize(final int newSize) {
        isPrime = Arrays.copyOf(isPrime, newSize);
    }

    private boolean[] initializePrimeNumbers() {
        final int START_NUMBER = 2;
        final int END_NUMBER = 1_000_000;
        isPrime = new boolean[END_NUMBER];
        setArray();
        calculatePrimeNumbers(START_NUMBER, END_NUMBER);
        return isPrime;
    }

    private void setArray() {
        Arrays.fill(isPrime, true);
        isPrime[0] = false;
        isPrime[1] = false;
    }

}
