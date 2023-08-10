import java.util.ArrayList;
import java.util.Scanner;

/**
 * Class which
 * @author Christian Morabito
 * @version ver1.0.0
 */
public class Input
{
    private String name;
    private int action;

    /**
     *
     */
    public Input()
    {
        name = "Unfilled";
        action = 0;
    }

    /**
     * @param action
     */
    public Input(int action)
    {
        this.name = "Unfilled";
        this.action = action;
    }

    /**
     * @param mainFlag
     * @param inputFlag
     * @param ice
     * @param log
     * @param freeze
     * @param buildingHeights
     * @param player
     */
    public void action(MainFlag mainFlag, InputFlag inputFlag, Ice ice, Log log, ArrayList<Boolean> freeze,
                       ArrayList<Integer> buildingHeights, Player player)
    {
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
     * @return
     */
    public int getAction()
    {
        return action;
    }

    /**
     * @return
     */
    public String getName()
    {
        return name;
    }

    /**
     * @param isFrozen
     * @param inputFlag
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
     * @param name
     */
    public void setName(String name)
    {
        this.name = name;
    }

    /**
     *
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
        while (Validation.stringLength(name.trim(), 3, 12));
    }

    /**
     * @param action
     */
    public void setAction(int action)
    {
        this.action = action;
    }
}
