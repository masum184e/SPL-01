class Move{
  Board b=new Board();
      String[] word={
      "abandon","able","abroad","absolutely","absorb",
      "access","accurate","accomplish","act","actual",
      "straight","stream","strategy","store","structure"
    };
  void set_item(){
    b.Board[b.index][100]=word[0].charAt(0);
    b.Board[b.index][101]=word[0].charAt(1);
    b.Board[b.index][102]=word[0].charAt(2);
  }
}