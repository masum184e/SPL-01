import java.util.*;
class SetInterval{
  //INTERVAL METHOD
  static void interval(int interval_time){
    new Timer().scheduleAtFixedRate(new TimerTask(){
      @Override
      public void run(){
        System.out.println("Hello");
      }
    },0,1000);
  }

  //MAIN METHOD
  public static void main(String[] args){
    interval(1000);
  }
}
