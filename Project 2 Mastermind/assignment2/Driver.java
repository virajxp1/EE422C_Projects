/*
 * EE422C Project 2 (Mastermind) submission by
 * <Viraj Parikh>
 * <VHP286>
 * Slip days used: <0>
 * Fall 2019
 */

package assignment2;
import java.awt.*;
import java.util.*;

public class Driver {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in); //Input scanner
        System.out.println("Welcome to Mastermind.");
        boolean testing = (args.length!=0 && args[0].equals("1"));
        while(true){
            boolean end = Game.checkGame(input);
            if(end)
                break;
            Game mastermind = new Game(testing);
            mastermind.runGame(input);
        }
    }
}
