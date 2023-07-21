package models;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URISyntaxException;
import java.util.Random;

public class ChallengeColour
{
  //PRIVATE INTERFACE
  private String _color_name;
  private String _color_hex;

  //PUBLIC INTERFACE
  public ChallengeColour(String color_name,
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
  public static ChallengeColour pickAColourFromJson()
  throws IOException, URISyntaxException
  {
    try (InputStream in = ChallengeColour.class.getResourceAsStream("ressources/colors.json");
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

      ChallengeColour challengeColour = new ChallengeColour(colorObject.getString("name"), colorObject.getString("hex"));

      return challengeColour;

    }
  }

}
