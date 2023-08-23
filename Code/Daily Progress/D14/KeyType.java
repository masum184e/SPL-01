import java.util.ArrayList;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

class KeyType{

  static String fileName = "data.txt";
  static int RowSize = 30;
  static int ColumnSize = 100;
  static char[][] BoardBox = new char[RowSize][ColumnSize];
  static int score = 0;
  
  public static void main(String[] args){

    Scanner get_input = new Scanner(System.in);
    FileManager readFileObject = new FileManager();
    Word wordObject = new Word();
    BoardManager boardObject = new BoardManager(BoardBox, RowSize, ColumnSize);

    ArrayList<String> wordList = readFileObject.read_data(fileName);
    ArrayList<WordIndex> boardWordList = new ArrayList<>();

    boolean isGameOver = false;

    while(!isGameOver){
      wordObject.addWord(wordList, boardWordList, ColumnSize);
      
      boardObject.setRandomWord(boardWordList,BoardBox);
      boardObject.displayBoard(BoardBox, RowSize, ColumnSize);

      System.out.println("Score: "+score);
      System.out.print("Enter Your Word: ");
      String user_input = get_input.nextLine();

      boolean found_status = wordObject.word_matching(boardWordList, user_input, BoardBox);
      if(found_status)score++;

      wordObject.word_down_fall(boardWordList, BoardBox);

      for(int i=0;i<boardWordList.size();i++)
        if(boardWordList.get(i).X==(RowSize-1))isGameOver=true;
    }
  }
}