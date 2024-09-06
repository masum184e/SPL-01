import java.util.Scanner;
import java.util.ArrayList;

class KeyType{
  static String wordData = "wordData.txt";
  static String resumeData = "resume.txt";
  static String correctWord= "correctWord.txt";
  static int rowSize = 30;
  static int columnSize = 100;
  static char[][] boardBox = new char[rowSize][columnSize];
  static int score = 0;
  static boolean resumeStatus = false;
  static final int gameTickInterval = 1000;
  static int wordAddCounter = 0;
  static final int wordAddInterval = 5;

  public static void main(String[] args){
    Scanner getInput = new Scanner(System.in);
    FileManager fileManager = new FileManager();
    WordManager wordManager= new WordManager();

    BoardManager boardManager = new BoardManager(boardBox, rowSize, columnSize);
    ArrayList<Word> boardWordList = new ArrayList<>();

    ArrayList<String> wordList = fileManager.readAllWordFromFile(wordData);

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
      long startTime = System.currentTimeMillis();
      wordManager.addWord(wordList, boardWordList, columnSize, rowSize, boardBox);

      if(resumeStatus && !fileManager.isFileEmpty(resumeData)){
        score=fileManager.correctWordLength(correctWord);
        boardWordList.remove(boardWordList.size()-1);
        resumeStatus=false;
      }else{
        wordAddCounter++;
        if(wordAddCounter>=wordAddInterval) {
          wordManager.addWord(wordList, boardWordList, columnSize, rowSize, boardBox);
          wordAddCounter = 0;
        }
      }

      boardManager.setBoardWithBoardWordList(boardWordList,boardBox);
      fileManager.writeWordWithIndexForResume(boardWordList, resumeData);
      boardManager.displayBoard(boardBox, rowSize, columnSize);

      System.out.println("\033[32mScore: "+score+"\033[0m");
      System.out.print("Enter Your Word: ");
      String userInput = getInput.nextLine();

      if(userInput.equals("exit")){
        System.exit(0);
      }

      boolean wordMatchingStatus = wordManager.wordMatching(boardWordList, userInput, boardBox);
      if(wordMatchingStatus){
        score++;
        fileManager.writeCorrectWord(correctWord,userInput);
      }

      wordManager.wordDownFall(boardWordList, boardBox);

      for(int i=0;i<boardWordList.size();i++){
        if(boardWordList.get(i).X==(rowSize-1)){
          isGameOver=true;
          boardWordList.clear();
          fileManager.writeWordWithIndexForResume(boardWordList, resumeData);
        }
      }

      long endTime = System.currentTimeMillis();
      long elapsedTime = endTime - startTime;

      if(elapsedTime<gameTickInterval){
          try{
              Thread.sleep(gameTickInterval-elapsedTime);
          }catch(InterruptedException e){
            e.printStackTrace();
          }
      }

    }

    if(isGameOver){

      boardManager.gameOver();
      System.out.println("\n\n\n\033[32mYour Score: "+ score+"\033[0m");

      fileManager.displayCorrectWord(correctWord);
      fileManager.clearCorrectWordFile(correctWord);
    }

  }
}