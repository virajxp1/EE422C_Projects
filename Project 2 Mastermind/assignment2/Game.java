package assignment2;

import java.util.Scanner;

public class Game {

    //fields here
    private boolean testing;
    private Code code;
    private int turns;

    //Write a constructor that takes a boolean value for testing or not
    public Game(boolean driver_input) {
        testing = driver_input;
        code = new Code();
        if (driver_input)
            code.printCode();
        turns = GameConfiguration.guessNumber;
    }

    public boolean runGame(Scanner input) {
        while (turns > 0) {

        }
        return false;
    }

    public void resetGame(){

    }

}
