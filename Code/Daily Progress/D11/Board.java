class Board{
  int ROWS=30;
  int COLS=200;
  char[][] BOARD_ITEM=new char[ROWS][COLS];
  
  void set_board_item(){
    for(int i=0;i<ROWS;i++){
      for(int j=0;j<COLS;j++){
        if(i!=0 && i!=29 && (j==0 || j==198))BOARD_ITEM[i][j]='|';
        else if(j==199)BOARD_ITEM[i][j]='\n';
        else if(i==0 || i==29)BOARD_ITEM[i][j]='=';
        else BOARD_ITEM[i][j]=' ';
      }
    }
  }

  void display_board(){
    for(int i=0;i<ROWS;i++){
      for(int j=0;j<COLS;j++){
        System.out.print(BOARD_ITEM[i][j]);
      }
    }
  }
}