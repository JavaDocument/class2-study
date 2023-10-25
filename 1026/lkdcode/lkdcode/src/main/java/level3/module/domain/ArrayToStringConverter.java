package level3.module.domain;

public class ArrayToStringConverter {

    private ArrayToStringConverter() {
    }

    public static ArrayToStringConverter newInstance() {
        return new ArrayToStringConverter();
    }

    public String booleanArrayToStringConverter(final boolean[] array) {
        final StringBuilder result = new StringBuilder();
        for (int i = 0; i < array.length; i++) {
            if (array[i]) {
                result.append("- ")
                        .append(i)
                        .append(System.lineSeparator());
            }
        }

        return result.toString();
    }

}
