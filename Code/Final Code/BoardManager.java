import java.util.ArrayList;

class BoardManager{
  BoardManager(char[][] BoardBox, int RowSize ,int ColumnSize){
    for(int i=0;i<RowSize;i++){
      for(int j=0;j<ColumnSize;j++){
        if(i!=0 && i!=(RowSize-1) && (j==0 || j==(ColumnSize-2)))BoardBox[i][j]='|';
        else if(j==ColumnSize-1)BoardBox[i][j]='\n';
        else if(i==0 || i==(RowSize-1))BoardBox[i][j]='=';
        else BoardBox[i][j]=' ';
      }
    }
  }

  void gameStart(){
    String[] pattern = {
    "##     ## ########### ##          ## ############## ##          ## #########   ###########",
    "##    ##  ###########  ##        ##  ##############  ##        ##  ##      ##  ###########",
    "##   ##   ##            ##      ##         ##         ##      ##   ##       ## ##         ",
    "##  ##    ##             ##    ##          ##          ##    ##    ##      ##  ##         ",
    "## ##     ##              ##  ##           ##           ##  ##     ##     ##   ##         ",
    "###       ###########      ####            ##            ####      #######     ###########",
    "###       ###########       ##             ##             ##       ##          ###########",
    "## ##     ##                ##             ##             ##       ##          ##         ",
    "##  ##    ##                ##             ##             ##       ##          ##         ",
    "##   ##   ##                ##             ##             ##       ##          ##         ",
    "##    ##  ###########       ##             ##             ##       ##          ###########",
    "##     ## ###########       ##             ##             ##       ##          ###########"};
    for(int i=0;i<pattern.length;i++){
      System.out.println(pattern[i]);
    }

    System.out.println("1. New Game");
    System.out.println("2. Resume");
  }

  void gameOver(){
    System.out.print("\033[H\033[2J");
    System.out.flush();
    String[] pattern = {
      "      #######         ####     ####          #### ###########     #######     ##          ## ########### ###### ",
      "     #########       ##  ##    ## ##        ## ## ###########    #########    ##          ## ########### ##    ##",
      "    ##       ##     ##    ##   ##  ##      ##  ## ##            ##       ##   ##          ## ##          ##     ##",
      "  ##          ##   ##      ##  ##   ##    ##   ## ##           ##         ##  ##          ## ##          ##    ##",
      "##             ## ##        ## ##    ##  ##    ## ##          ##           ## ##          ## ##          ##  ##",
      "##                ############ ##     ####     ## ########### ##           ## ##          ## ########### ####",
      "##         ###### ##        ## ##              ## ########### ##           ## ##          ## ########### ####",
      "##         ###### ##        ## ##              ## ##          ##           ##  ##        ##  ##          ## ##",
      "  ##          ##  ##        ## ##              ## ##           ##         ##    ##      ##   ##          ##  ##",
      "   ##        ##   ##        ## ##              ## ##            ##       ##      ##    ##    ##          ##   ##",
      "    #########     ##        ## ##              ## ###########    #########        ##  ##     ########### ##    ##",
      "     #######      ##        ## ##              ## ###########     #######          ####      ########### ##     ##"};

    for(int i=0;i<pattern.length;i++){
      System.out.println(pattern[i]);
    }
  }

  void displayBoard(char[][] BoardBox, int RowSize ,int ColumnSize){
    for(int i=0;i<RowSize;i++){
      for(int j=0;j<ColumnSize;j++){
        System.out.print(BoardBox[i][j]);
      }
    }
  }
  
  void setBoardWithBoardWordList(ArrayList<Word> wordList, char[][] BoardBox){
    for(int i=0;i<wordList.size();i++){
      for(int j=0;j<wordList.get(i).word.length();j++){
        BoardBox[wordList.get(i).X][wordList.get(i).Y+j]=wordList.get(i).word.charAt(j);
      }
    }
  }
}