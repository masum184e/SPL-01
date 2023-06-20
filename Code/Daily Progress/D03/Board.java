class Board{
  int ROWS=30,COLS=200;
  char[][] Board=new char[ROWS][COLS];
  boolean[][] Bool=new boolean[ROWS][COLS];
  void set_board(){
    for(int i=0;i<ROWS;i++){
      for(int j=0;j<COLS;j++){
        if(i==0 || i==(ROWS-1)){
          Board[i][j]='=';
          Bool[i][j]=true;
        }
        if((i!=0 && i!=(ROWS-1))&&(j==0 || j==(COLS-1))){
          Board[i][j]='|';
          Bool[i][j]=true;
        }
        else if(i!=0 && i!=29){
          Board[i][j]=' ';
          Bool[i][j]=false;
        }
      }
    }
  }
  void display_board(){
    for(int i=0;i<ROWS;i++){
      for(int j=0;j<COLS;j++){
        System.out.print(Board[i][j]);
      }
      System.out.println();
    }
  }
}