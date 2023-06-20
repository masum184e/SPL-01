import java.lang.Math;
class Random{
  ReadFile rf=new ReadFile();
  int generate_random_number(int min, int max){
    return (int)(Math.random()*(max-min+1)+min);
  }
  // String random_word(){
  //   System.out.println(rf.data);
  //   return "a";
  //   // return rf.data.get(generate_random_number(0,rf.data.size()));
  // }
}