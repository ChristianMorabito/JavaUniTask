import java.util.ArrayList;
import java.util.Arrays;

public class Print
{

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static void chargeAmount(int amount)
    {
        if (amount > 0)
        {
            String chargeBlock = "█ ".repeat(amount);
            System.out.print(chargeBlock);
        }
        System.out.println(amount + "\n");
    }
    public static void frozen(State state) {

        if (state.isFrozen()) {
            System.out.println("\uD83D\uDEA8 YOU ARE FROZEN \uD83D\uDEA8");
        }
    }
    public static void web(State state) {

        if (state.isWebbed()) {
            System.out.println("\uD83D\uDEA8 YOU ARE WEBBED!! \uD83D\uDEA8");
        }
    }

    public static void fuelRespawning(boolean fuelShuffleCheck)
    {
        if (fuelShuffleCheck)
        {
            System.out.println("\uD83D\uDEA8 FUEL RESPAWNING \uD83D\uDEA8");
        }

    }

    public static void fuelCollected(ArrayList<Boolean> fuelArray, int currentSpot, int chargeCount)
    {
        if (fuelArray.get(currentSpot))
        {
            if (chargeCount == 20)
            {
                System.out.println("✅✅ MAX FUELED ✅✅");
            }
            System.out.println("✅ FUELED ✅");

        }
    }

    public static void outOfRange(State state)
    {
        if (state.isOutOfRange())
        {
            System.out.println("\uD83D\uDEA8 BEYOND RANGE: Retry \uD83D\uDEA8");
        }
    }

    public static void graphic(Parse parse, int[] positions)
    {
        StringBuilder[][] buildingString = new Graphic().create(parse, positions);
        System.out.println();
        for (int i = 0; i < Data.MAX_HEIGHT + 1; i++)
        {
            String formattedString = Arrays.toString(buildingString[i])
                    .replace(",", "")
                    .replace("[", "")
                    .replace("]", "");
            System.out.println(formattedString);
        }
    }

    public static void exit(int amount, String name, boolean exit, boolean webbed)
    {
        if (!exit)
        {
            String webbedString = "were WEBBED which ";
            if (amount > 0)
            {
                System.out.println("Congratulations, " + name + "! You have escaped the Nowhere Dimension!!");
                return;
            }
            webbedString = webbed ? webbedString : "";
            System.out.println("Oh no, " + name + "! You " + webbedString + "drained your fuel! You remain trapped in the Nowhere Dimension!! ");
        }
        System.out.println("--GAME OVER--");
    }

    public static void action(boolean frozen)
    {
        if (!frozen){
            System.out.print("""
                ┎------------------------------┒
                │ Enter a number between 1 & 4 │
                │ 1) Jump RIGHT                |
                │ 2) Jump LEFT                 │
                │ 3) Skip Turn                 │
                │ 4) Exit                      │
                └------------------------------┘
                """);
            return;
        }

        System.out.print("""
                ┎------------------------------┒
                │                              │
                │     You have lost a turn     │
                │                              │
                │         Press  ENTER         │
                │                              │
                └------------------------------┘
                """);
    }



    public static void invalidInput()
    {
        System.out.println("Invalid Input! Please try again.");
    }



}
