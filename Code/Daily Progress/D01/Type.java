class Type{
  public static void main(String[] args){
    for(int i=0;i<30;i++){
      for(int j=0;j<150;j++){
        if(i==0 || i==29)System.out.print("=");
        if((j==0 || j==149) && (i!=0 && i!=29))System.out.print("|");
        else if(i!=0 && i!=29) System.out.print(" ");
      }
      System.out.println();
    }
  }
}