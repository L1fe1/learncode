package designpattern.sevenprinciples.dp;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Reader {

    int a,b;
    private String path;
    private BufferedReader br;
    public Reader(String path) throws Exception{
        super();
        this.path = path;
        setBufferedReader();
        readLine();
    }
    //注意，我们变为私有的方法
    private void setBufferedReader() throws FileNotFoundException {
        br = new BufferedReader(new FileReader(path));
    }
    //注意，我们变为私有的方法
    private void readLine() throws NumberFormatException, IOException {
        a = Integer.valueOf(br.readLine());
        b = Integer.valueOf(br.readLine());
    }
    
    public int getA(){
        return a;
    }
    
    public int getB(){
        return b;
    }
}