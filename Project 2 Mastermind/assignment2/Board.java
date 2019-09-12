package assignment2;

import java.util.ArrayList;
import java.lang.System;

public class Board {
    private Code secret;
    private ArrayList<Code> History;

    public Board(Code secret){
        this.secret = secret;
        History = new ArrayList<Code>();
    }

    public boolean CalculatePegs(Code guess){
        int black_pegs = 0;
        int white_pegs = 0;
        History.add(guess);
        System.out.print(guess.getCode());
        black_pegs = black(guess,secret);
        white_pegs = white(guess,secret)-black_pegs;
        System.out.println(" -> " + black_pegs + "b_" + white_pegs+"w");
        if(black_pegs == 4)
            return true;
        else
            return false;
    }

    public static int black( Code guess, Code secret) {
        int b =0;
        for(int i = 0;i<GameConfiguration.pegNumber;i++) {
            if (guess.getCode().charAt(i) == secret.getCode().charAt(i))
                b++;
        }
        return b;
    }
    public static int white (Code guess, Code secret){
        int w = 0;

        //remove duplicates from guess
        String removeDupes = "";
        for(int i = 0;i<guess.getCode().length();i++){
            boolean repeat = false;
            for(int j = i+1;j<guess.getCode().length();j++){
                if(guess.getCode().charAt(i) == guess.getCode().charAt(j)){
                    repeat = true;
                    break;
                }
            }
            if(!repeat)
                removeDupes += guess.getCode().charAt(i);
        }

        for(int i = 0;i<removeDupes.length();i++){
            // check if the guess color exist in the secret code
            for(int j = 0;j<GameConfiguration.pegNumber;j++){
                if(removeDupes.charAt(i) == secret.getCode().charAt(j)){
                    w++;
                    break;
                }
            }
        }
        return  w;
    }

    public void printHistory(){
        for(int i = 0;i<History.size();i++){
            System.out.print(History.get(i).getCode());
            int black_pegs = black(History.get(i),secret);
            int white_pegs = white(History.get(i),secret)-black_pegs;
            System.out.println(" -> " + black_pegs + "b_" + white_pegs+"w");
        }
    }
}
