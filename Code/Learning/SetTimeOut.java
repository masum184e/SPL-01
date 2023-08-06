class SetTimeOut{
  // TIMEOUT METHOD IN MILLISECONDS
  static void time_out(int time){
    try {
      Thread.sleep(time);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

  // MAIN METHOD 
  public static void main(String[] args){
    System.out.println("Delay Start");
    time_out(5000);
    System.out.println("Delay End");
  }
}
