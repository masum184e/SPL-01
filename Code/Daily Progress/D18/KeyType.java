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
        fileManager.writeWordWithIndexForResume(boardWordList, resumeData);
        break;
      }
      case 2:{
        fileManager.readWordWithIndexForResume(boardWordList,resumeData);
        resumeStatus=true;
        break;
      }
      default: {
        System.out.println("Invalid Output");
      }
    }

    boolean isGameOver = false;

    while(!isGameOver){

      word.addWord(wordList, boardWordList, columnSize);

      if(resumeStatus && !fileManager.isFileEmpty(resumeData)){
        boardWordList.remove(boardWordList.size()-1);
        resumeStatus=false;
      }

      boardManager.setBoardWithBoardWordList(boardWordList,boardBox);
      boardManager.displayBoard(boardBox, rowSize, columnSize);

      fileManager.writeWordWithIndexForResume(boardWordList, resumeData);

      System.out.println("\033[32mScore: "+score+"\033[0m");
      System.out.print("Enter Your Word: ");
      String userInput = getInput.nextLine();

      boolean wordMatchingStatus = word.wordMatching(boardWordList, userInput, boardBox);
      if(wordMatchingStatus)score++;

      word.wordDownFall(boardWordList, boardBox);

      for(int i=0;i<boardWordList.size();i++)
        if(boardWordList.get(i).X==(rowSize-1)){
          isGameOver=true;
          boardWordList.clear();
          fileManager.writeWordWithIndexForResume(boardWordList, resumeData);
        }
    }



    if(isGameOver){
      boardManager.gameOver();
      System.out.println("\n\n\n\033[32mYour Score: "+ score+"\033[0m");
    }


  }
}
