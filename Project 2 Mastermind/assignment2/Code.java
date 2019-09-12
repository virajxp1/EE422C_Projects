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
        return temp.length() != GameConfiguration.pegNumber;
    }

    private boolean checkContent(String temp){
        for(int i = 0;i<temp.length();i++){
            if(!checkLetter(temp.substring(i,i)))
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
        String temp = input.next();
        while(!checkLength(temp)){
            System.out.println("INVALID GUESS");
            temp = input.next();
        }
        while(!checkContent(temp)){
            System.out.println("INVALID GUESS");
            temp = input.next();
        }
        this.code = temp;
    }

    public String getCode(){
        return code;
    }
}
