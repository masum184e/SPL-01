import java.util.ArrayList;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

class KeyType{

  static String wordData = "wordData.txt";
  static String resumeData = "resume.txt";
  static String correctWord= "correctWord.txt";
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
    Timer intervalTimer = new Timer();

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
    score=fileManager.correctWordLength(correctWord);

    while(!isGameOver){

      word.addWord(wordList, boardWordList, columnSize, rowSize, boardBox);

      if(resumeStatus && !fileManager.isFileEmpty(resumeData)){
        boardWordList.remove(boardWordList.size()-1);
        resumeStatus=false;
      }else{
        intervalTimer.scheduleAtFixedRate(new TimerTask(){
          @Override
          public void run(){
            word.addWord(wordList, boardWordList, columnSize, rowSize, boardBox);
          }
        }, 0, 1000);
      }

      boardManager.setBoardWithBoardWordList(boardWordList,boardBox);
      boardManager.displayBoard(boardBox, rowSize, columnSize);

      fileManager.writeWordWithIndexForResume(boardWordList, resumeData);

      System.out.println("\033[32mScore: "+score+"\033[0m");
      System.out.print("Enter Your Word: ");
      String userInput = getInput.nextLine();

      boolean wordMatchingStatus = word.wordMatching(boardWordList, userInput, boardBox);
      if(wordMatchingStatus){
        score++;
        fileManager.writeCorrectWord(correctWord,userInput);
      }

      word.wordDownFall(boardWordList, boardBox);

      for(int i=0;i<boardWordList.size();i++)
        if(boardWordList.get(i).X==(rowSize-1)){
          isGameOver=true;
          boardWordList.clear();
          fileManager.writeWordWithIndexForResume(boardWordList, resumeData);
        }
    }



    if(isGameOver){
      if(intervalTimer!=null){
        intervalTimer.cancel();
      }
      boardManager.gameOver();
      System.out.println("\n\n\n\033[32mYour Score: "+ score+"\033[0m");
      fileManager.correctWordList(correctWord);
      fileManager.emptyCorrectWord(correctWord);
    }


  }
}
