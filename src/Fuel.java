import java.util.ArrayList;

public class Fuel
{
    private ArrayList<Boolean> array;
    private Count count;

    public Fuel()
    {
        array = new ArrayList<>();
        count = new Count();
    }

    public Fuel(Count count)
    {
        this.array = new ArrayList<>();
        this.count = count;
    }

    public void collect(int currentPosition)
    {
        if (array.get(currentPosition))
        {
            array.set(currentPosition, false);
        }
    }

    public ArrayList<Boolean> getArray()
    {
        return array;
    }

    public void setArray(ArrayList<Boolean> array)
    {
        this.array = array;
    }
}
