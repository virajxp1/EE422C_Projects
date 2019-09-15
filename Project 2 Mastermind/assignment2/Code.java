/*
 * EE422C Project 2 (Mastermind) submission by
 * <Viraj Parikh>
 * <VHP286>
 * Slip days used: <0>
 * Fall 2019
 */

package assignment2;

import java.util.Scanner;
import java.util.Arrays;

public class Code {
    private String code;

    public Code(){
        code = SecretCodeGenerator.getInstance().getNewSecretCode();
    }

    public Code(String guess){
        code = guess;
    }

    public void printCode(){ System.out.println(code); }

    private boolean checkLength(String temp){
        return (temp.length() == GameConfiguration.pegNumber);
    }

    private boolean checkContent(String temp){
        for(int i = 0;i<temp.length();i++){
            if(!checkLetter(temp.substring(i,i+1)))
                return false;
        }
        return true;
    }

    private boolean checkLetter(String letter){
        for(int i = 0;i<GameConfiguration.colors.length;i++){
            if(letter.equals(GameConfiguration.colors[i]))
                return true;
        }
        return false;
    }

    public void getGuess(Scanner input) {
        this.code = input.next();
    }
    public boolean validateGuess(Board gameboard){
        if(code.equals("HISTORY")){
            gameboard.printHistory();
            return false;
        }
        if(!checkLength(code)){
            System.out.println("INVALID_GUESS");
            return false;
        }
        while(!checkContent(code)){
            System.out.println("INVALID_GUESS");
            return false;
        }
        return true;
    }
    public String getCode(){
        return code;
    }
}
