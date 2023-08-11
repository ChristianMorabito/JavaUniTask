import java.util.ArrayList;
import java.util.Scanner;

/**
 * Class which accepts game input, i.e.
 * player's name & player's play choice.
 * @author Christian Morabito
 * @version ver1.0.0
 */
public class Input
{
    private String name;
    private int action;

    /**
     * Default Constructor for Player class
     */
    public Input()
    {
        name = "Unfilled";
        action = 0;
    }

    /**
     * Non-default constructor for Player class
     * @param action accepts int for player's action
     */
    public Input(int action)
    {
        this.name = "Unfilled";
        this.action = action;
    }

    /**
     * method that receives player's input and computes the
     * appropriate action
     * @param mainFlag accepts mainFlag object
     * @param inputFlag accepts inputFlag object
     * @param ice  accepts ice object
     * @param log accepts log object
     * @param array accepts array object
     * @param player accepts player object
     */
    public void action(MainFlag mainFlag, InputFlag inputFlag, Ice ice, Log log, Array array, Player player)
    {
        ArrayList<Boolean> freeze = array.getFreeze();
        ArrayList<Integer> buildingHeights = array.getBuildings();

        if (inputFlag.isInvalidInput())
        {
            return;
        }
        switch (action)
        {
            case 0 ->
            {
                inputFlag.setNumbers(!inputFlag.isNumbers());
                inputFlag.setNumbersLoop(true);
                return;
            }
            case 4 ->
            {
                System.out.println("Exiting...");
                mainFlag.setGameRunning(false);
                mainFlag.setExit(true);
            }
            default ->
            {
                ice.setStatus(false);
                player.move(inputFlag, freeze, buildingHeights, action);
            }
        }

        inputFlag.setNumbersLoop(false);
        if (action != 4)
        {
            log.setTurnCount(log.getTurnCount() + 1);
        }
    }

    /**
     * display method to print the state
     * of the class fields
     */
    public void display()
    {
        System.out.println("Name: " + name + "\n" +
                           "Action: " + action);
    }

    /**
     * Accessor method to get action int
     * @return returns action int
     */
    public int getAction()
    {
        return action;
    }

    /**
     * Accessor method to get name String
     * @return returns name String
     */
    public String getName()
    {
        return name;
    }

    /**
     * method that accepts player int input & validates input
     * @param isFrozen accepts boolean which determines if player is on frozen building
     * @param inputFlag accepts inputFlag object
     */
    public void inputAction(boolean isFrozen, InputFlag inputFlag)
    {
        Scanner scanner = new Scanner(System.in);
        boolean condition = true;

        try
        {
            System.out.print("Number: ");
            action = scanner.nextInt();
            condition = isFrozen ? Validation.betweenRanges(action, 0, 0, 3, 4) :
                        Validation.integerLength(action, 0, 4);
        }
        catch (Exception e)
        {
            scanner.next();
        }
        inputFlag.setInvalidInput(condition);

    }

    /**
     * Mutator method that sets action int
     * @param action accepts int for player action
     */
    public void setAction(int action)
    {
        this.action = action;
    }

    /**
     * Mutator method that sets name string
     * @param name accepts name string
     */
    public void setName(String name)
    {
        this.name = name;
    }

    /**
     * method that accepts input which validates & sets name string field
     */
    public void usernameInput()
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your username. It must be between 3 to 12 letters long.");

        do
        {
            System.out.print("Name: ");
            this.name = scanner.nextLine();
        }
        while (Validation.stringRange(name.trim(), 3, 12));
    }
}
