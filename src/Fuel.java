import java.sql.SQLOutput;
import java.util.ArrayList;

public class Fuel
{
    private ArrayList<Boolean> currentFuel;

    private State state;

    Fuel()
    {
        currentFuel = new ArrayList<>();
        state = new State();
    }

    Fuel(State state)
    {
        this.currentFuel = new ArrayList<>();
        this.state = state;
    }


    public void print(int currentPosition)
    {
        String fuelCollected = "";

        if (state.fuelShuffleCheck())
        {
            System.out.println("\uD83D\uDEA8 FUEL RESPAWNING \uD83D\uDEA8");
        }

        if (currentFuel.get(currentPosition))
        {
            fuelCollected = "  FUELED" + "✅";
        }

        for (int i = 0; i < currentFuel.size(); i++)
        {
            if (i == currentPosition) {
                System.out.print(fuelCollected);
            }
            else
            {
                System.out.print("             ");
            }
        }
        System.out.println();

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
