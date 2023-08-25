import java.nio.file.Files;
import java.nio.file.Path;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
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

    void writeData(String fileName, ArrayList<WordIndex> boardWordList){
        try (BufferedWriter writter = new BufferedWriter(new FileWriter(fileName))) {
            for(int i=0;i<boardWordList.size();i++){
                writter.write(boardWordList.get(i).word+"|"+boardWordList.get(i).X+"|"+boardWordList.get(i).Y+"\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    boolean isFileEmpty(String fileName){
        try{
            Path path = Path.of(fileName);
            return (Files.size(path)==0)?true:false;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    void addWordList(ArrayList<WordIndex> boardWordList, String fileName){
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] components = line.split("\\|");
                WordIndex wordIndexObject = new WordIndex(components[0], Integer.parseInt(components[1]), Integer.parseInt(components[2]));
                boardWordList.add(wordIndexObject);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}