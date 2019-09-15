/*
 * EE422C Project 2 (Mastermind) submission by
 * <Viraj Parikh>
 * <VHP286>
 * Slip days used: <0>
 * Fall 2019
 */

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
        if (driver_input){
            System.out.print("Secret Code:");
            code.printCode();
        }
        turns = GameConfiguration.guessNumber;
    }

    public void runGame(Scanner input) { //Game engine
        Board gameBoard = new Board(code);
        while (turns > 0) {
            Code guess = new Code("");
            do{
                printStartTurn();
                guess.getGuess(input);
            }
            while(!guess.validateGuess(gameBoard));
            boolean win = gameBoard.CalculatePegs(guess);
            if(win){
                System.out.println("You win!");
                System.out.println("");
                return;
            }
            turns--;
        }
        System.out.println("You lose! The pattern was " + code.getCode());
        System.out.println();
    }

    public void printStartTurn(){
        System.out.println("");
        System.out.println("You have "+this.turns+" guess(es) left.");
        System.out.println("Enter guess:");
    }

    public static boolean checkGame(Scanner input){
        System.out.println("Do you want to play a new game? (Y/N):");
        if(!input.next().equals("Y"))
            return true;
        return false;
    }
}
