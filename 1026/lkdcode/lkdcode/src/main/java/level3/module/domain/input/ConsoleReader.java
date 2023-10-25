package level3.module.domain.input;

import java.util.Scanner;

public class ConsoleReader {
    private final Scanner scanner = new Scanner(System.in);

    private ConsoleReader() {
    }

    public static ConsoleReader newInstance() {
        return new ConsoleReader();
    }

    public String read() {
        return scanner.nextLine();
    }

}
