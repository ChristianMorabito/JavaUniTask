import java.util.ArrayList;
import java.util.Scanner;

public class Input
{
    private String name;

    private State state;

    private int action;

    public Input()
    {
        this.state = new State();
        this.name = "Unfilled";
        this.action = 0;
    }

    public Input(State state)
    {
        this.state = state;
        this.name = "Unfilled";
        this.action = 0;
    }
    public void usernameInput()
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your username. It must be between 3 to 12 letters long.");
        boolean inputInvalid = true;

        while (inputInvalid)
        {
            System.out.print("Name: ");
            name = scanner.nextLine();
            if (name.length() < 3)
            {
                System.out.println("Name too short. Please try again.");
            }
            else if (name.length() > 12)
            {
                System.out.println("Name too long. Please try again.");
            }
            else
            {
                inputInvalid = false;
            }
        }

    }

    private void frozenInput()
    {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Press ENTER: ");
        while (!scanner.hasNextLine());

    }

    public void action(Log log, ArrayList<Integer> buildingHeights, Position position)
    {
        if (state.isFrozen())
        {
            return;
        }

        switch (action)
        {
            case 0 ->
            {
                state.setNumbers(!state.isNumbers());
                state.setNumbersLoop(true);
                return;
            }
            case 4 ->
            {
                System.out.println("Exiting...");
                state.setGameRunning(false);
                state.setExit(true);
            }
            default ->
                position.move(buildingHeights, action);
        }

        state.setNumbersLoop(false);
        log.setTurnCount(log.getTurnCount() + 1);
    }

    public void inputAction()
    {
        if (state.isFrozen()) {
            frozenInput();
            return;
        }

        Scanner scanner = new Scanner(System.in);

        while (true)
        {
            try
            {
                System.out.print("Number: ");
                action = scanner.nextInt();
                if (action > -1 && action < 5)
                {
                    break;
                }
            }
            catch (Exception e)
            {
                Print.invalidInput();
                scanner.next();
            }
        }
    }

    public String getName()
    {
        return name;
    }

    public int getAction()
    {
        return action;
    }

    public void setAction(int action)
    {
        this.action = action;
    }

    public void setName(String name)
    {
        this.name = name;
    }
}
