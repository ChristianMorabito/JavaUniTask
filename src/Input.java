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

    public void action(Log log, ArrayList<Integer> buildingHeights, Position position)
    {
        if (state.isFrozen())
        {
            return;
        }

        switch (action)
        {
            case 0 -> {
                state.setNumbers(!state.isNumbers());
                state.setNumbersLoop(true);
                return;
            }
            case 4 -> {
                System.out.println("Exiting...");
                state.setGameRunning(false);
                state.setExit(true);
            }
            default -> position.move(buildingHeights, action);
        }

        state.setNumbersLoop(false);
        log.setTurnCount(log.getTurnCount() + 1);
    }

    public int getAction()
    {
        return action;
    }

    public String getName()
    {
        return name;
    }

    public void inputAction()
    {
        if (state.isFrozen()) {
            frozenInput();
            return;
        }

        Scanner scanner = new Scanner(System.in);

        do
        {
            try
            {
                System.out.print("Number: ");
                action = scanner.nextInt();
            }
            catch (Exception e)
            {
                Print.invalidInput();
                scanner.next();
            }

        }
        while (Validation.integerLength(action, 0, 4));

    }

    public void setName(String name)
    {
        this.name = name;
    }

    private void frozenInput()
    {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Press ENTER: ");
        while (!scanner.hasNextLine());

    }

    public void usernameInput()
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your username. It must be between 3 to 12 letters long.");

        do
        {
            System.out.print("Name: ");
            name = scanner.nextLine();
        }
        while (Validation.stringLength(name.trim(), 3, 12));
    }

    public void setAction(int action)
    {
        this.action = action;
    }
}
