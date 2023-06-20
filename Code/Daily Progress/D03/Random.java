class Random{
  static int generate_random_number(int min, int max){
    return (int)(Math.random()*(max-min+1)+min);
  }
  public static void main(String[] args){
    System.out.println("Random Number Between 0 and 100: "+generate_random_number(0,100));
  }
}