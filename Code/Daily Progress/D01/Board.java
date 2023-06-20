class Board{
  int ROWS=30,COLS=200;
  char[][] Board=new char[ROWS][COLS];
  void set_board(){
    for(int i=0;i<ROWS;i++){
      for(int j=0;j<COLS;j++){
        if(i==0 || i==(ROWS-1))Board[i][j]='=';
        if((j==0 || j==(COLS-1)) && i!=0 && i!=(ROWS-1))Board[i][j]='|';
        // else Board[i][j]=' ';
      }
    }
  }
  void display_board(){
    for(int i=0;i<ROWS;i++){
      for(int j=0;j<COLS;j++){
        System.out.println(Board[i][j]);
      }
      System.out.println();
    }
  }
}