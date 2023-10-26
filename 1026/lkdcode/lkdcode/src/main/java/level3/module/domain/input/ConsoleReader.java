package level3.module.domain.input;

import static common.Console.readLine;

public class ConsoleReader {

    private ConsoleReader() {
    }

    public static ConsoleReader newInstance() {
        return new ConsoleReader();
    }

    public String read() {
        return readLine();
    }

}
