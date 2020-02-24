package control;

import java.util.Scanner;

public class control{

    protected Scanner user_input = new Scanner(System.in);

    public control() {
        
        
    }

    public String read_and_return() {
        String input = user_input.nextLine();

        return input;
    }
}