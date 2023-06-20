import java.util.*;
class TimeInterval{
  Board b=new Board();
  Move m=new Move();
  public void interval(){
    new Timer().scheduleAtFixedRate(new TimerTask(){
    @Override
      public void run(){
        if(b.index>0 && b.index<b.ROWS){
        System.out.println(b.index);

          b.display_board();
          b.index=(b.index)+1;
          m.set_item();
        }
      }
    },0,5000);
  }
}