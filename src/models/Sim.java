package models;

import java.util.*;

public class Sim
{

  //PRIVATE INTERFACE
  private int _sim_id;
  private int _sim_age_type;

  //PRIVATE STATIC INTERFACE
  private static int _global_sim_id = 0;

  //PUBLIC INTERFACE
  public Sim()
  {
    this._sim_id       = _sim_age_type++;
    this._sim_age_type = (int) Math.floor(Math.random() * this.SIM_AGE_TYPES.size()) + 1;
  }

  public Sim(int sim_age_type)
  {
    this._sim_id       = _sim_age_type++;
    this._sim_age_type = sim_age_type;
  }

  public String getAgeTypeToString()
  {
    return this.SIM_AGE_TYPES.get(this._sim_age_type);
  }

  public int getSimId()
  {
    return this._sim_id;
  }

  //PUBLIC STATIC INTERFACE
  public static ArrayList<Sim> getSimList()
  {
    ArrayList<Sim> sims_list    = new ArrayList<>();
    int            maximum_sims = GeneratorSettings.getRandomBetweenConstants(GeneratorSettings.SIMS_MINIMUM, GeneratorSettings.SIMS_MAXIMUM);

    for (int i = 0; i < (maximum_sims - 1); i++)
      sims_list.add(new Sim());

    sims_list.add(new Sim(1)); //At least one adult sim

    return sims_list;
  }

  public static String getSimListDescriptionAsString(ArrayList<Sim> sims_list)
  {
    String list_of_sims_string = "";

    for(int i=0; i<sims_list.size(); i++)
    {
      list_of_sims_string = list_of_sims_string + "One " + sims_list.get(i).getAgeTypeToString();
      if(i<sims_list.size()-1)
        list_of_sims_string = list_of_sims_string + ", ";
      else
        list_of_sims_string = list_of_sims_string + ".";
    }

    return list_of_sims_string;
  }

  //PUBLIC CONSTANTS
  public static final int AGE_TYPE_ADULT    = 1;
  public static final int AGE_TYPE_TEENAGER = 2;
  public static final int AGE_TYPE_CHILDREN = 3;
  public static final int AGE_TYPE_TODDLER  = 4;
  public static final int AGE_TYPE_INFANT   = 5;
  public static final int AGE_TYPE_NEWBORN  = 6;

  //PRIVATE CONSTANTS
  private static final HashMap<Integer, String> SIM_AGE_TYPES = new HashMap<Integer, String>()
  {{
    put(AGE_TYPE_ADULT, "adult");
    put(AGE_TYPE_TEENAGER, "teenager");
    put(AGE_TYPE_CHILDREN, "children");
    put(AGE_TYPE_TODDLER, "toddler");
    put(AGE_TYPE_INFANT, "infant");
    put(AGE_TYPE_NEWBORN, "newborn");
  }};

}
