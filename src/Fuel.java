import java.util.ArrayList;

public class Fuel
{
    private ArrayList<Boolean> currentFuel;

    private State state;

    public Fuel()
    {
        currentFuel = new ArrayList<>();
        state = new State();
    }

    public Fuel(State state)
    {
        this.currentFuel = new ArrayList<>();
        this.state = state;
    }


    public void print(int currentPosition, int chargeCount)
    {

        if (state.fuelShuffleCheck())
        {
            System.out.println("\uD83D\uDEA8 FUEL RESPAWNING \uD83D\uDEA8");
        }

        if (currentFuel.get(currentPosition))
        {
            if (chargeCount == 20)
            {
                System.out.println("✅✅ MAX FUELED ✅✅");
            }
            System.out.println("✅ FUELED ✅");

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
