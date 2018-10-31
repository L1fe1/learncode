import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


public class ReadFile {
    private static void readFile1(File fin) throws IOException {
        FileInputStream fis = new FileInputStream(fin);
        //Construct BufferedReader from InputStreamReader
        BufferedReader br = new BufferedReader(new InputStreamReader(fis));
    
        String line = null;
        while ((line = br.readLine()) != null) {
            System.out.println(line);
        }
        br.close();
    }

    private static void readFile2(File fin) throws IOException {
        // Construct BufferedReader from FileReader
        BufferedReader br = new BufferedReader(new FileReader(fin));
    
        String line = null;
        while ((line = br.readLine()) != null) {
            System.out.println(line);
        }
    
        br.close();
    }

    private static void readFile3(Path path) {
        Charset charset = Charset.forName("US-ASCII");
        try (BufferedReader reader = Files.newBufferedReader(path, charset)) {
            String line = null;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException x) {
            System.err.format("IOException: %s%n", x);
        }
    }

    public static void main(String[] args) {
        //use . to get current directory
        File dir = new File(".");
        try {
            File fin = new File(dir.getCanonicalPath() + File.separator + "in.txt");
            Path path = Paths.get(dir.getCanonicalPath() + File.separator + "in.txt"); // "D:\\learncode\\in.txt"
            readFile1(fin);
            readFile2(fin);
            readFile3(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}