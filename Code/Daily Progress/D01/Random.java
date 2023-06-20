import java.lang.Math;
class Random{
  int generate_random_number(int min, int max){
    return (int)(Math.random()*(max-min+1)+min);
  }
}