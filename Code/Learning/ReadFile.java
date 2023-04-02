import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ReadFile {
    public static void main(String[] args) {

        //FILE I WANT TO READ
        String fileName = "data.txt";

        //ARRAY LIST TO STORE THE FILE DATA
        ArrayList<String> data = new ArrayList<String>();

        //READING THE FILE
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                data.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        //PRINTING FILE DATA
        for(String i:data){
            System.out.println(i);
        }
    }
}
