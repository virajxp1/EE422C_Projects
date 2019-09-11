package assignment2;
import java.util.*;

public class Driver {
    public static void main(String[] args){
        Game mastermind = new Game(args[0].equals(1)); //Game
        Scanner input = new Scanner(System.in); //Input scanner
        boolean Gameend = false;
        while(!Gameend){
            mastermind.runGame(input);
            mastermind.resetGame();
        }
    }
}
