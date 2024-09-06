import java.util.ArrayList;

class WordManager{
  PseudoRandomNumber randomNumberGenerator = new PseudoRandomNumber(System.currentTimeMillis());

  void addWord(ArrayList<String> wordList, ArrayList<Word> boardWordList, int ColumnSize, int rowSize, char[][] boardBox){
    int randomWordIndex = randomNumberGenerator.generateRandomNumber(0, wordList.size() - 1);
    String randomWord = wordList.get(randomWordIndex);
    int randomColumnIndex = randomNumberGenerator.generateRandomNumber(1, ColumnSize - randomWord.length() - 2);
    int randomRowIndex = randomNumberGenerator.generateRandomNumber(1, 10);

    boolean canAddWord=true;
    outerLoop:
    for(int i=randomColumnIndex-1;i<=randomColumnIndex+randomWord.length();i++){
      for(int j=0;j<boardWordList.size();j++){
        for(int k=boardWordList.get(j).Y;k<=boardWordList.get(j).word.length()+boardWordList.get(j).Y;k++){
          if(i==k && boardWordList.get(j).X==randomRowIndex){
            canAddWord=false;
            break outerLoop;
          }
        }        
      }
    }

    if(canAddWord){
      Word word = new Word(randomWord, randomRowIndex, randomColumnIndex);
      boardWordList.add(word);
    }
  }

  boolean wordMatching(ArrayList<Word> boardWordList, String userInput, char[][] BoardBox){
    for(int i=0;i<boardWordList.size();i++){
      if(userInput.equals(boardWordList.get(i).word)){
        for(int j=0;j<boardWordList.get(i).word.length();j++){
          BoardBox[boardWordList.get(i).X][boardWordList.get(i).Y+j]=' ';
        }
        boardWordList.remove(i);
        return true;
      }
    }
    return false;
  }

  void wordDownFall(ArrayList<Word> boardWordList, char[][] BoardBox){
    for(int i=0;i<boardWordList.size();i++){
      for(int j=0;j<boardWordList.get(i).word.length();j++){
        BoardBox[boardWordList.get(i).X][boardWordList.get(i).Y+j]=' ';
      }
    }
    for(int i=0;i<boardWordList.size();i++){
      boardWordList.get(i).X=boardWordList.get(i).X+1;
    }
  }

}