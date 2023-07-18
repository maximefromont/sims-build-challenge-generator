import java.util.HashMap;
import java.util.Map;

public class House
{

  //PRIVATE INTERFACE
  private int     _house_id;
  private int     _house_size_type;
  private int     _house_style_type;
  private int     _house_floors;
  private boolean _house_basements;
  private int     _house_rooms;

  //PRIVATE STATIC INTERFACE
  private static int _global_house_id;

  //PUBLIC INTERFACE
  House()
  {
    this._house_id         = _global_house_id++;
    this._house_size_type  = (int) Math.floor(Math.random() * this.HOUSE_SIZE_TYPES.size()) + 1;
    this._house_style_type = (int) Math.floor(Math.random() * this.HOUSE_STYLE_TYPES.size()) + 1;
    this._house_floors     = GeneratorSettings.getRandomBetweenConstants(GeneratorSettings.HOUSE_FLOORS_MINIMUM, GeneratorSettings.HOUSE_FLOORS_MAXIMUM);
    this._house_basements  = Math.random() > 0.5;
    this._house_rooms      = generateHouseRooms();
  }

  //PRIVATE INTERFACE
  private int generateHouseRooms()
  {
    switch(this._house_size_type)
    {
      case SIZE_TYPE_SMALL:
        return GeneratorSettings.getRandomBetweenConstants(GeneratorSettings.HOUSE_SMALL_ROOMS_MINIMUM, GeneratorSettings.HOUSE_SMALL_ROOMS_MAXIMUM);
      case SIZE_TYPE_MEDIUM:
        return GeneratorSettings.getRandomBetweenConstants(GeneratorSettings.HOUSE_MEDIUM_ROOMS_MINIMUM, GeneratorSettings.HOUSE_MEDIUM_ROOMS_MAXIMUM);
      case SIZE_TYPE_BIG:
        return GeneratorSettings.getRandomBetweenConstants(GeneratorSettings.HOUSE_BIG_ROOMS_MINIMUM, GeneratorSettings.HOUSE_BIG_ROOMS_MAXIMUM);
      default:
        return 0;
    }
  }

  public String getSizeTypeToString()
  {
    return this.HOUSE_SIZE_TYPES.get(this._house_size_type);
  }

  public String getStyleTypeToString()
  {
    return this.HOUSE_STYLE_TYPES.get(this._house_style_type);
  }

  public int get_house_floors()
  {
    return _house_floors;
  }

  public boolean get_house_basements()
  {
    return _house_basements;
  }

  public int get_house_rooms()
  {
    return _house_rooms;
  }

  //PUBLIC CONSTANT
  public static final int SIZE_TYPE_SMALL  = 1;
  public static final int SIZE_TYPE_MEDIUM = 2;
  public static final int SIZE_TYPE_BIG    = 3;

  public static final int STYLE_TYPE_BRITISHCOUNTRY = 1;
  public static final int STYLE_TYPE_MODERNCOUNTRY  = 2;
  public static final int STYLE_TYPE_FANCY          = 3;
  public static final int STYLE_TYPE_BASIC          = 4;
  public static final int STYLE_TYPE_MAGIC          = 5;
  public static final int STYLE_TYPE_VERYMODERN     = 6;

  //PRIVATE CONSTANT
  private static final HashMap<Integer, String> HOUSE_SIZE_TYPES = new HashMap<Integer, String>()
  {{
    put(SIZE_TYPE_SMALL, "small");
    put(SIZE_TYPE_MEDIUM, "medium");
    put(SIZE_TYPE_BIG, "big");
  }};

  private static final HashMap<Integer, String> HOUSE_STYLE_TYPES = new HashMap<Integer, String>()
  {{
    put(STYLE_TYPE_BRITISHCOUNTRY, "british country");
    put(STYLE_TYPE_MODERNCOUNTRY, "modern country");
    put(STYLE_TYPE_FANCY, "fancy");
    put(STYLE_TYPE_BASIC, "basic");
    put(STYLE_TYPE_MAGIC, "magic");
    put(STYLE_TYPE_VERYMODERN, "very modern");
  }};

}
