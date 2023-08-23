import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

class FileManager {
    ArrayList<String> data = new ArrayList<String>();
    
    ArrayList<String> read_data(String fileName){
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                data.add(line);
            }        
        } catch (IOException e) {
            e.printStackTrace();
        }
        return data;
    }
}