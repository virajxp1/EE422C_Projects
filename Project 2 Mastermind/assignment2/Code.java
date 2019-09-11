package assignment2;

import java.util.Scanner;

public class Code {
    private String code;

    public Code(){
        code = SecretCodeGenerator.getInstance().getNewSecretCode();
    }

    public Code(String guess){
        code = guess;
    }

    public void printCode(){ System.out.println(code); }

    public void getGuess(Scanner input) {
        String temp = input.next();
        while(temp.length() != GameConfiguration.pegNumber){
            System.out.println("INVALID GUESS");
            temp = input.next();
        }
        while(true){
            boolean end = true;
            for(int i = 0;i<GameConfiguration.colors.length;i++){
                if(!temp.contains(GameConfiguration.colors[i]))
                    end = false;
            }
            if(!end)
                break;
            else{
                System.out.println("INVALID GUESS");
                temp = input.next();
            }
        }
        this.code = temp;
    }
}
