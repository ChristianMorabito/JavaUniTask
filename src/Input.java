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
        while (true)
        {
            System.out.print("Username: ");
            name = scanner.nextLine();
            System.out.println();
            if (name.length() > 2 && name.length() < 13)
            {
                break;
            }
            else
            {
                Print.invalidInput();
            }
        }
    }

    private void frozenInput()
    {
        Scanner scanner = new Scanner(System.in);
        while (!scanner.hasNextLine());

    }

    public void action()
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
                if (action > 0 && action < 5)
                {
                    break;
                }
                Print.invalidInput();

            }
            catch (Exception e)
            {
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
