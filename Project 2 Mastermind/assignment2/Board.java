/*
 * EE422C Project 2 (Mastermind) submission by
 * <Viraj Parikh>
 * <VHP286>
 * Slip days used: <0>
 * Fall 2019
 */

package assignment2;

import java.util.ArrayList;
import java.lang.System;
import java.util.HashMap;

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
        HashMap<String,Integer> secretFreq = new HashMap<String,Integer>();
        HashMap<String,Integer> guessFreq = new HashMap<String, Integer>();
        int total = 0;
        for(int i = 0;i<secret.getCode().length();i++){
            if(secretFreq.containsKey(secret.getCode().substring(i,i+1))){
                int oldF = secretFreq.get(secret.getCode().substring(i,i+1));
                oldF++;
                secretFreq.replace(secret.getCode().substring(i,i+1),oldF);
            }
            else{
                secretFreq.put(secret.getCode().substring(i,i+1),1);
            }
        }
        for(int i = 0;i<guess.getCode().length();i++){
            if(guessFreq.containsKey(guess.getCode().substring(i,i+1))){
                int oldF = guessFreq.get(guess.getCode().substring(i,i+1));
                oldF++;
                guessFreq.replace(guess.getCode().substring(i,i+1),oldF);
            }
            else{
                guessFreq.put(guess.getCode().substring(i,i+1),1);
            }
        }

        for(int i = 0;i<GameConfiguration.colors.length;i++){
            if(secretFreq.containsKey(GameConfiguration.colors[i]) && guessFreq.containsKey(GameConfiguration.colors[i])){
                if(guessFreq.get(GameConfiguration.colors[i]) < secretFreq.get(GameConfiguration.colors[i])){
                    total += guessFreq.get(GameConfiguration.colors[i]);
                }
                else if(guessFreq.get(GameConfiguration.colors[i]) > secretFreq.get(GameConfiguration.colors[i])){
                    total += secretFreq.get(GameConfiguration.colors[i]);
                }
                else{
                    total += guessFreq.get(GameConfiguration.colors[i]);
                }
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
