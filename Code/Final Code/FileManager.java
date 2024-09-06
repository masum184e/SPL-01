import java.io.IOException;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.nio.file.Files;
import java.nio.file.Path;

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
    
    void writeCorrectWord(String fileName, String userInput){
        try (BufferedWriter writter = new BufferedWriter(new FileWriter(fileName, true))) {
            writter.write(userInput+"\n");
        } catch (IOException e) {
            e.printStackTrace();
        }       
    }

    void writeWordWithIndexForResume(ArrayList<Word> boardWordList, String fileName){
        try (BufferedWriter writter = new BufferedWriter(new FileWriter(fileName))) {
            for(int i=0;i<boardWordList.size();i++){
                writter.write(boardWordList.get(i).word+"|"+boardWordList.get(i).X+"|"+boardWordList.get(i).Y+"\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void displayCorrectWord(String fileName){
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

    void clearCorrectWordFile(String fileName){
        try (BufferedWriter writter = new BufferedWriter(new FileWriter(fileName))) {
            writter.write("");
        } catch (IOException e) {
            e.printStackTrace();
        }  
    }

    void readWordWithIndexForResume(ArrayList<Word> boardWordList, String fileName){
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] components = line.split("\\|");
                Word word = new Word(components[0], Integer.parseInt(components[1]), Integer.parseInt(components[2]));
                boardWordList.add(word);
            }
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

    boolean isFileEmpty(String fileName){
        try{
            Path path = Path.of(fileName);
            return (Files.size(path)==0)?true:false;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

}