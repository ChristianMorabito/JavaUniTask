import java.util.ArrayList;

/**
 * Class to mutate indexes within fuel object which is regenerated
 * every 3rd iteration.
 * @author Christian Morabito
 * @version ver1.0.0
 **/

public class Fuel
{
    private ArrayList<Boolean> array;
    private Count count;

    /**
     * Default constructor which creates the object of the class Fuel.
     */
    public Fuel()
    {
        array = new ArrayList<>();
        count = new Count();
    }

    /**
     * Non-default constructor which creates the object of the class Fuel.
     * @param count Accepts Count object
     */
    public Fuel(Count count)
    {
        this.array = new ArrayList<>();
        this.count = count;
    }

    /**
     * Method which changes fuel array index from true to false
     * @param currentPosition integer represents current position index
     **/
    public void collect(int currentPosition)
    {
        if (array.get(currentPosition))
        {
            array.set(currentPosition, false);
        }
    }

    /**
     * Accessor method to get fuel arraylist (boolean)
     **/
    public ArrayList<Boolean> getArray()
    {
        return array;
    }

    /**
     * Mutator method to set fuel arraylist (boolean)
     **/
    public void setArray(ArrayList<Boolean> array)
    {
        this.array = array;
    }
}