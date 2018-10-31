import java.io.IOException;


public class Calculator {

    public int add(int a,int b){
        return a + b;
    }
    
    public static void main(String[] args) throws NumberFormatException, IOException {
        Reader reader = new Reader("D:/learncode/data.txt");
        Calculator calculator = new Calculator();
        System.out.println("result:" + calculator.add(reader.getA(),reader.getB()));
    }
    
}