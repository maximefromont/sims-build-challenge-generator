import java.util.HashMap;

public class Pet
{

  //PRIVATE INTERFACE
  private int _pet_id;
  private int _pet_type;

  //PRIVATE STATIC INTERFACE
  private static int _global_pet_id = 0;

  //PUBLIC INTERFACE
  public Pet()
  {
    this._pet_id = _global_pet_id++;
    this._pet_type = (int) Math.floor(Math.random() * this.PET_TYPES.size()) + 1;
  }


  //PUBLIC CONSTANTS
  public static final int TYPE_CAT = 1;
  public static final int TYPE_DOG = 2;

  //PRIVATE CONSTANTS
  private static final HashMap<Integer, String> PET_TYPES = new HashMap<Integer, String>()
  {{
    put(TYPE_CAT, "cat");
    put(TYPE_DOG, "dog");
  }};
}
