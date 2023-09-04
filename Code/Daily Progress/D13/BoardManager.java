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
  void display_board(char[][] BoardBox, int RowSize ,int ColumnSize){
    System.out.print("\033[H\033[2J");
    System.out.flush();
    for(int i=0;i<RowSize;i++){
      for(int j=0;j<ColumnSize;j++){
        System.out.print(BoardBox[i][j]);
      }
    }
  }
  void word_down_fall(ArrayList<WordIndex> wordIndex, char[][] BoardBox){
    for(int i=0;i<wordIndex.size();i++){
      for(int j=0;j<wordIndex.get(i).word.length();j++){
        BoardBox[wordIndex.get(i).X][wordIndex.get(i).Y+j]=' ';
      }
    }
    for(int i=0;i<wordIndex.size();i++){
      wordIndex.get(i).X=wordIndex.get(i).X+1;
    }
  }

  boolean word_matching(ArrayList<WordIndex> wordIndex, String user_input, char[][] BoardBox){
    for(int i=0;i<wordIndex.size();i++){
      if(user_input.equals(wordIndex.get(i).word)){
        for(int j=0;j<wordIndex.get(i).word.length();j++){
          BoardBox[wordIndex.get(i).X][wordIndex.get(i).Y+j]=' ';
        }
        wordIndex.remove(i);
        return true;
      }
    }
    return false;
  }

  boolean game_over(ArrayList<WordIndex> wordIndex, int RowSize){
    for(int i=0;i<wordIndex.size();i++){
      if(wordIndex.get(i).X==(RowSize-1))return true;
    }
    return false;
  }
  
  void set_random_word(char[][] BoardBox, WordIndex wordIndexObject){
    for(int i=0;i<wordIndexObject.word.length();i++){
      BoardBox[wordIndexObject.X][wordIndexObject.Y+i]=wordIndexObject.word.charAt(i);
    }
  }
}