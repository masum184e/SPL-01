class Word{
  ReadFile rf=new ReadFile();
  Random r=new Random();
  String random_word;
  String get_random_word(){
    rf.read_data();
    random_word=rf.data.get(r.generate_random_number(0,rf.data.size()));
    return random_word;
  }
}