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
    for(int i=0;i<RowSize;i++){
      for(int j=0;j<ColumnSize;j++){
        System.out.print(BoardBox[i][j]);
      }
    }
  }
  void set_random_word(char[][] BoardBox, WordIndex wordIndexObject){
    for(int i=0;i<wordIndexObject.word.length();i++){
      BoardBox[wordIndexObject.X][wordIndexObject.Y+i]=wordIndexObject.word.charAt(i);
    }
  }
}