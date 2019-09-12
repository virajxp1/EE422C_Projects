package assignment2;

import java.util.ArrayList;
import java.util.*;
import java.lang.System;

public class Board {
    private Code secret;
    private ArrayList<Code> History;

    public Board(Code secret){
        this.secret = secret;
    }

    public boolean CalculatePegs(Code guess){
        int black_pegs = 0;
        int white_pegs = 0;
        for(int i = 0;i<GameConfiguration.pegNumber;i++){
            if(guess.getCode().charAt(i) == secret.getCode().charAt(i))
                black_pegs++;
            else if(guess.getCode().charAt(i) != secret.getCode().charAt(i)){
                if(guess.getCode().indexOf(secret.getCode().charAt(i)) > 0)
                    white_pegs++;
            }
        }
        History.add(guess);
        System.out.println(guess.toString() + " -> " + black_pegs + "b_" + white_pegs+"w");

        if(black_pegs == 4)
            return true;
        else
            return false;
    }

    public void printHistory(){
        for(Code i : History){
            //Print code
        }
    }
}
