package assignment2;

public class Code {
    private String code;

    public Code(){
        code = SecretCodeGenerator.getInstance().getNewSecretCode();
    }

    public Code(String guess){
        code = guess;
    }

    public void printCode(){
        System.out.println(code);
    }
}
