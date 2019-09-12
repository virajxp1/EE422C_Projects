package assignment2;
import java.util.*;

public class Driver {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in); //Input scanner
        System.out.println("Welcome to Mastermind");
        Game mastermind;
        if(args.length!= 0) {
            boolean testing = args[0].equals("1");
            mastermind = new Game(testing); //Game
        }
        else
            mastermind = new Game(false); //Game
        boolean Gameend = mastermind.checkGame(input);
        while(!Gameend){
            mastermind.runGame(input);
            mastermind.resetGame();
            Gameend = mastermind.checkGame(input);
        }
    }
}
