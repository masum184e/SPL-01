import java.util.ArrayList;
import java.util.Scanner;
class KeyType{
  
  ArrayList<Integer> posX=new ArrayList<Integer>();
  ArrayList<Integer> posY=new ArrayList<Integer>();
  int word_item_index=0;

  public static void main(String[] args){
    String word;
    Scanner get_input = new Scanner(System.in);
    KeyType kt=new KeyType();
    Board b=new Board();
    Move m=new Move();
    b.set_board_item();

    while(true){
        m.move(kt,b);
        b.display_board();
        // m.move(kt,b);
        // b.display_board();
        word=get_input.next();
    }

  }
}