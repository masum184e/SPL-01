class ClearConsole{
  public static void main(String[] args){
    System.out.println("This Will Not Diplay");
    System.out.print("\033[H\033[2J");
    System.out.flush();
    System.out.println("After Clearing The Console");
  }
}
