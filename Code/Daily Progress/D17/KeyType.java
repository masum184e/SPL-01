import java.util.ArrayList;
import java.util.Scanner;

class KeyType{

  static String wordData = "wordData.txt";
  static String resumeData = "resume.txt";
  static int rowSize = 30;
  static int columnSize = 100;
  static char[][] boardBox = new char[rowSize][columnSize];
  static int score = 0;
  static boolean resumeStatus = false;

  public static void main(String[] args){

    Scanner getInput = new Scanner(System.in);
    FileManager fileManager = new FileManager();
    Word word = new Word();
    BoardManager boardManager = new BoardManager(boardBox, rowSize, columnSize);

    ArrayList<String> wordList = fileManager.readAllWordFromFile(wordData);
    ArrayList<WordIndex> boardWordList = new ArrayList<>();

    boardManager.gameStart();
    System.out.print("Enter Your Choice: ");
    int choice = getInput.nextInt();
    getInput.nextLine();
    switch(choice){
      case 1:{
        fileManager.writeWordWithIndexForResume(resumeData, boardWordList);
        break;
      }
      case 2:{
        fileManager.readWordWithIndexForResume(boardWordList,resumeData);
        resumeStatus=true;
        break;
      }
      case 3:{
        System.out.println("Highest Score: 0000");
        break;
      }
    }

    boolean isGameOver = false;

    while(!isGameOver){
      word.addWord(wordList, boardWordList, columnSize);

      if(resumeStatus){
        boardWordList.remove(boardWordList.size()-1);
        resumeStatus=false;
      }

      boardManager.setBoardWithBoardWordList(boardWordList,boardBox);
      boardManager.displayBoard(boardBox, rowSize, columnSize);

      fileManager.writeWordWithIndexForResume(resumeData, boardWordList);

      System.out.println("Score: "+score);
      System.out.print("Enter Your Word: ");
      String userInput = getInput.nextLine();

      boolean wordMatchingStatus = word.wordMatching(boardWordList, userInput, boardBox);
      if(wordMatchingStatus)score++;

      word.wordDownFall(boardWordList, boardBox);


      for(int i=0;i<boardWordList.size();i++)
        if(boardWordList.get(i).X==(rowSize-1)){
          isGameOver=true;
          boardWordList.clear();
          fileManager.writeWordWithIndexForResume(resumeData, boardWordList);
        }
    }

    if(isGameOver){
      boardManager.gameOver();
      System.out.println("Your Score: "+ score);
    }
  }
}