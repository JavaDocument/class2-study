package level3.domain.output;

public class Print {

    public void printResult(final boolean[] primeNumbers) {
        System.out.println("== 결과 ==");
        final StringBuilder result = makeMessage(primeNumbers);
        System.out.println(result);
    }

    private StringBuilder makeMessage(final boolean[] primeNumbers) {
        final StringBuilder result = new StringBuilder();
        final int START_NUMBER = 2;

        for (int number = START_NUMBER; number < primeNumbers.length; number++) {
            if (primeNumbers[number]) {
                result.append("- ")
                        .append(number)
                        .append(System.lineSeparator());
            }
        }

        return result;
    }

}
