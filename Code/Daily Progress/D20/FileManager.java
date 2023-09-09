import java.nio.file.Files;
import java.nio.file.Path;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

class FileManager {
    ArrayList<String> readAllWordFromFile(String fileName){
        ArrayList<String> data = new ArrayList<String>();

        String line;
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            while ((line = reader.readLine()) != null) {
                data.add(line);
            }        
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        return data;
    }

    void writeWordWithIndexForResume(ArrayList<WordIndex> boardWordList, String fileName){
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

    void readWordWithIndexForResume(ArrayList<WordIndex> boardWordList, String fileName){
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] components = line.split("\\|");
                WordIndex wordIndexObject = new WordIndex(components[0], Integer.parseInt(components[1]), Integer.parseInt(components[2]));
                boardWordList.add(wordIndexObject);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void writeCorrectWord(String fileName, String userInput){
         try (BufferedWriter writter = new BufferedWriter(new FileWriter(fileName, true))) {
            writter.write(userInput+"\n");
        } catch (IOException e) {
            e.printStackTrace();
        }       
    }

    int correctWordLength(String fileName){
        int lineCount = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                lineCount++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lineCount;
    }

    void emptyCorrectWord(String fileName){
        try (BufferedWriter writter = new BufferedWriter(new FileWriter(fileName))) {
            writter.write("");
        } catch (IOException e) {
            e.printStackTrace();
        }  
    }
    
    void correctWordList(String fileName){
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            int count=1;
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(count+". "+line);
                count++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}