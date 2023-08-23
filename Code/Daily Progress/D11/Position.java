class Position{
  Random r=new Random();
  Word w=new Word();
  void set_position(KeyType kt, Board b){
    String random_word=w.get_random_word();
    for(int i=0;i<random_word.length();i++){
      b.BOARD_ITEM[kt.posX.get(kt.word_item_index)][kt.posY.get(kt.word_item_index)+i]=random_word.charAt(i);
    }
  }
}