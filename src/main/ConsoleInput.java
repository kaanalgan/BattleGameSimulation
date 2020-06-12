package main;

import java.util.Scanner;

public class ConsoleInput implements Input{
    @Override
    public String readString() {
        Scanner scanner = new Scanner(System.in);
        String userInput = scanner.nextLine();
        scanner.close();
        return userInput;
    }

    @Override
    public int readInt() {
        Scanner scanner = new Scanner(System.in);
        int userInput = scanner.nextInt();
        scanner.close();
        return userInput;
    }
}
