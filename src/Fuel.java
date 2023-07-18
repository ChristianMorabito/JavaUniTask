import java.util.ArrayList;

public class Fuel
{
    private ArrayList<Boolean> currentFuel;

    private ArrayList<Boolean> previousFuel;

    Fuel()
    {
        currentFuel = new ArrayList<>();
    }

    Fuel(ArrayList<Boolean> currentFuel)
    {
        this.currentFuel = currentFuel;

    }

    public void print(int currentPosition)
    {
        if (currentFuel.get(currentPosition))
        {
            for (int i = 0; i < currentPosition; i++)
            {
                System.out.print("                 ");
            }
            System.out.println("Fuel Collected!!");
        }
    }

    public void collectFuel(int currentPosition)
    {
        if (currentFuel.get(currentPosition))
        {
            currentFuel.set(currentPosition, false);
        }
    }

    public ArrayList<Boolean> getCurrentFuel()
    {
        return currentFuel;
    }

    public void setCurrentFuel(ArrayList<Boolean> currentFuel)
    {
        this.currentFuel = currentFuel;
    }
}
