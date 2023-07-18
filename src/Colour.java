import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Random;

public class Colour
{
  //PRIVATE INTERFACE
  private String _color_name;
  private String _color_hex;

  //PUBLIC INTERFACE
  public Colour(String color_name,
                String color_hex)
  {
    this._color_name = color_name;
    this._color_hex  = color_hex;
  }

  public String get_color_name()
  {
    return _color_name;
  }
  public String get_color_hex() { return _color_hex; }

  //PUBLIC STATIC INTERFACE
  public static Colour pickAColourFromJson()
  throws IOException, URISyntaxException
  {
    String      path  = "/src/ressources/colors.json";
    try (InputStream in = Main.class.getResourceAsStream("ressources/colors.json");
         BufferedReader reader = new BufferedReader(new InputStreamReader(in))) {

      StringBuilder sb = new StringBuilder();
      String line;
      while ((line = reader.readLine()) != null) {
        sb.append(line);
      }

      String jsonContent = sb.toString();
      JSONArray jsonArray = new JSONArray(jsonContent);

      Random random      = new Random();
      int    randomIndex = random.nextInt(jsonArray.length());

      JSONObject colorObject = jsonArray.getJSONObject(randomIndex);

      Colour colour = new Colour(colorObject.getString("name"), colorObject.getString("hex"));

      return colour;

    }
  }

}
