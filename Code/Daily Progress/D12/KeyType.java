import java.util.ArrayList;
import java.util.Scanner;

class KeyType{

  static String fileName = "data.txt";
  static int RowSize = 30;
  static int ColumnSize = 100;
  static char[][] BoardBox = new char[RowSize][ColumnSize];

  public static void main(String[] args){
    Scanner get_input = new Scanner(System.in);
    FileManager readFileObjeect = new FileManager();
    PseudoRandomNumber randomNumberObject = new PseudoRandomNumber(System.currentTimeMillis());
    BoardManager boardObject = new BoardManager(BoardBox, RowSize, ColumnSize);

    ArrayList<WordIndex> wordIndex = new ArrayList<>();
    ArrayList<String> AllWord = readFileObjeect.read_data(fileName);
    
    while(true){
      String randomWord = AllWord.get(randomNumberObject.generateRandomNumber(0, AllWord.size()-1));
      WordIndex wordIndexObject = new WordIndex(randomWord,1,randomNumberObject.generateRandomNumber(1, ColumnSize-2));
      wordIndex.add(wordIndexObject);
      
      boardObject.set_random_word(BoardBox, wordIndexObject);
      boardObject.display_board(BoardBox, RowSize, ColumnSize);

      System.out.print("Enter Your Word: ");
      String user_input = get_input.nextLine();

      
    }

  }
}