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
        white_pegs = totalCorrectPegs(guess,secret)-black_pegs;
        System.out.println(" -> " + black_pegs + "b_" + white_pegs+"w");
        if(black_pegs == GameConfiguration.pegNumber)
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

    public int totalCorrectPegs(Code guess,Code secret){
        //HashMap<String,Integer> colorSeen= new HashMap(); //Hash map to mark if the
        int total = 0;

        for(int i = 0;i<secret.getCode().length();i++){
            if(guess.getCode().contains(secret.getCode().substring(i,i+1))){
                total++;
            }
        }

        return total;
    }

    public void printHistory(){
        for(int i = 0;i<History.size();i++){
            System.out.print(History.get(i).getCode());
            int black_pegs = black(History.get(i),secret);
            int white_pegs = totalCorrectPegs(History.get(i),secret)-black_pegs;
            System.out.println(" -> " + black_pegs + "b_" + white_pegs+"w");
        }
    }
}
