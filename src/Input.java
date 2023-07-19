import java.util.Scanner;

public class Input
{
    private String userName;

    private int action;

    Input()
    {
        this.userName = "Unfilled";
        this.action = 0;
    }

    Input(String userName, int action)
    {
        this.userName = userName;
        this.action = action;
    }
    public void usernameInput()
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your username. It must be between 3 to 12 letters long.");
        while (true)
        {
            System.out.print("Username: ");
            userName = scanner.nextLine();
            System.out.println();
            if (userName.length() > 2 && userName.length() < 13 && userName.matches("[a-zA-Z]+"))
            {
                break;
            }
            else
            {
                System.out.println("Invalid input! Please try again.");
            }
        }
    }

    public void actionInput()
    {
        Scanner scanner = new Scanner(System.in);
        System.out.print("""
                ┎------------------------------┒
                │ Enter a number between 1 & 4 │
                │ 1) Jump RIGHT                |
                │ 2) Jump LEFT                 │
                │ 3) Skip Turn                 │
                │ 4) Exit                      │
                └------------------------------┘
                """);

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
                System.out.println("Invalid Input! Please try again.");

            }
            catch (Exception e)
            {
                scanner.next();
            }
        }
        String line = "──────────";
        System.out.println(line.repeat(20));
    }

    public String getUserName()
    {
        return userName;
    }

    public int getAction()
    {
        return action;
    }

    public void setAction(int action)
    {
        this.action = action;
    }

    public void setUserName(String userName)
    {
        this.userName = userName;
    }
}
