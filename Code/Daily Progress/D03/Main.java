class Main{
  public static void main(String[] args){
    Board b=new Board();
    b.set_board();
    // b.display_board();
    String[] word={
      "abandon","able","abroad","absolutely","absorb",
      "access","accurate","accomplish","act","actual",
      "straight","stream","strategy","store","structure"
    };
    b.Board[1][100]=word[0].charAt(0);
    b.Board[1][101]=word[0].charAt(1);
    b.Board[1][102]=word[0].charAt(2);
    b.Board[1][104]=word[1].charAt(0);
    b.Board[1][105]=word[1].charAt(1);
    b.Board[1][106]=word[1].charAt(2);

    b.Board[2][50]=word[0].charAt(0);
    b.Board[2][51]=word[0].charAt(1);
    b.Board[2][52]=word[0].charAt(2);
    b.Board[2][54]=word[1].charAt(0);
    b.Board[2][55]=word[1].charAt(1);
    b.Board[2][56]=word[1].charAt(2);

    b.Board[3][54]=word[0].charAt(0);
    b.Board[3][55]=word[0].charAt(1);
    b.Board[3][56]=word[0].charAt(2);
    b.Board[3][58]=word[1].charAt(0);
    b.Board[3][59]=word[1].charAt(1);
    b.Board[3][60]=word[1].charAt(2);

    b.display_board();
    System.out.println("Your Word: ");



    
  }
}