import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = "";
        TestParser testParser = new TestParser();
        while (!input.equals("finish")) {
            input = scanner.nextLine();
            testParser.parseCommand(input);
        }
    }
}