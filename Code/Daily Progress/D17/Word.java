import java.util.ArrayList;

class Word{
  PseudoRandomNumber randomNumberGenerator = new PseudoRandomNumber(System.currentTimeMillis());

  void addWord(ArrayList<String> wordList, ArrayList<WordIndex> boardWordList, int ColumnSize){
    int randomWordIndex = randomNumberGenerator.generateRandomNumber(0, wordList.size() - 1);
    String randomWord = wordList.get(randomWordIndex);
    int randomColumnIndex = randomNumberGenerator.generateRandomNumber(1, ColumnSize - randomWord.length() - 2);
    WordIndex wordIndexObject = new WordIndex(randomWord, 1, randomColumnIndex);
    boardWordList.add(wordIndexObject);
  }

  boolean wordMatching(ArrayList<WordIndex> boardWordList, String userInput, char[][] BoardBox){
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

  void wordDownFall(ArrayList<WordIndex> boardWordList, char[][] BoardBox){
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