class Move{
    Random r=new Random();
    Position p=new Position();
    void init_move(KeyType kt){
      kt.posX.add(1);
      kt.posY.add(r.generate_random_number(5,155));
    }

    void move(KeyType kt, Board b){
      init_move(kt);
      p.set_position(kt,b);
      kt.word_item_index=kt.word_item_index+1;
    }
}