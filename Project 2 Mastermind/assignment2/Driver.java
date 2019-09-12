package assignment2;
import java.util.*;

public class Driver {
    public static void main(String[] args){
        Game mastermind;
        if(args.length!= 0)
            mastermind = new Game(args[0].equals(1)); //Game
        else
            mastermind = new Game(false); //Game
        Scanner input = new Scanner(System.in); //Input scanner
        System.out.println("Welcome to Mastermind");
        boolean Gameend = mastermind.checkGame(input);
        while(!Gameend){
            mastermind.runGame(input);
            mastermind.resetGame();
            Gameend = mastermind.checkGame(input);
        }
    }
}
