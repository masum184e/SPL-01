class Main{
  public static void main(String[] args){
    Board b=new Board();
    ReadFile rf=new ReadFile();
    Random r=new Random();
    b.set_board();
    // b.display_board();
    rf.read_data();
    String random_word=rf.data.get(r.generate_random_number(0,rf.data.size()));
    System.out.println(random_word);
    // System.out.println(r.random_word());
  }
}