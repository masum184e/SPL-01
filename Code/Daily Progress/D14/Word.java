import java.util.ArrayList;

class Word{
  PseudoRandomNumber randomNumberObject = new PseudoRandomNumber(System.currentTimeMillis());

  void addWord(ArrayList<String> wordList, ArrayList<WordIndex> boardWordList, int ColumnSize){
    int randomWordIndex = randomNumberObject.generateRandomNumber(0, wordList.size() - 1);
    String randomWord = wordList.get(randomWordIndex);
    int randomColumnIndex = randomNumberObject.generateRandomNumber(1, ColumnSize - randomWord.length() - 2);
    WordIndex wordIndexObject = new WordIndex(randomWord, 1, randomColumnIndex);
    boardWordList.add(wordIndexObject);
  }

  boolean word_matching(ArrayList<WordIndex> boardWordList, String user_input, char[][] BoardBox){
    for(int i=0;i<boardWordList.size();i++){
      if(user_input.equals(boardWordList.get(i).word)){
        for(int j=0;j<boardWordList.get(i).word.length();j++){
          BoardBox[boardWordList.get(i).X][boardWordList.get(i).Y+j]=' ';
        }
        boardWordList.remove(i);
        return true;
      }
    }
    return false;
  }

  void word_down_fall(ArrayList<WordIndex> boardWordList, char[][] BoardBox){
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