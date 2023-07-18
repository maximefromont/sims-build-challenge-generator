public class GeneratorSettings
{

    public static final int SIMS_MAXIMUM = 8;
    public static final int SIMS_MINIMUM = 1;

    public static final int HOUSE_FLOORS_MAXIMUM = 3;
    public static final int HOUSE_FLOORS_MINIMUM = 1;
    public static final int HOUSE_BIG_ROOMS_MAXIMUM = 25;
    public static final int HOUSE_BIG_ROOMS_MINIMUM = 12;
    public static final int HOUSE_MEDIUM_ROOMS_MAXIMUM = 12;
    public static final int HOUSE_MEDIUM_ROOMS_MINIMUM = 5;
    public static final int HOUSE_SMALL_ROOMS_MAXIMUM = 5;
    public static final int HOUSE_SMALL_ROOMS_MINIMUM = 1;

    public static final int COLORS_MAXIMUM = 2;
    public static final int COLORS_MINIMUM = 1;

    public static int getRandomBetweenConstants(int minimum, int maximum)
    {
        return minimum + (int) (Math.random() * (maximum - minimum + 1));
    }


}
