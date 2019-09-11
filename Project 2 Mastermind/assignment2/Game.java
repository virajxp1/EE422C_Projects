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

    public void runGame(Scanner input) {
        while (turns > 0) {
            System.out.println("");
            System.out.println("You have "+this.turns+" guess(es) left");
            System.out.println("Enter guess:");
            Code guess = new Code(input.next());
        }
    }

    public void resetGame(){

    }

    public boolean checkGame(Scanner input){
        System.out.println("Do you want to play a new game? (Y/N):");
        if(!input.next().equals("Y"))
            return true;
        return false;
    }
}
