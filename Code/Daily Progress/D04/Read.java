import java.io.FileReader;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

class Read {
   public static void main(String[] args) {
      JSONParser parser = new JSONParser();
      try {
         Object obj = parser.parse(new FileReader("data.json"));
         JSONObject jsonObject = (JSONObject) obj;
         System.out.println(jsonObject);
      } catch (Exception e) {
         e.printStackTrace();
      }
   }
}
