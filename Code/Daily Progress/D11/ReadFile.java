import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

class ReadFile {
    ArrayList<String> data = new ArrayList<String>();
    String fileName = "data.txt";
    void read_data(){
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                data.add(line);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
