import java.util.ArrayList;
import java.util.Arrays;

public class Print
{

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static void chargeAmount(int amount, boolean numbers)
    {

        String chargeNumber = numbers ? String.valueOf(amount) : "";
        String chargeBlock = "█ ".repeat(amount);
        System.out.println();
        System.out.println("Charge: " + chargeBlock + chargeNumber);
        System.out.println();

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

    public static void graphic(Parse parse, int[] positions, boolean numbers)
    {
        StringBuilder[][] buildingString = new Graphic().create(parse, positions, numbers);
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
        System.out.println();
        if (!frozen){
            System.out.println("┎-------LEGEND-------┒  Enter a number between 0 & 4:");
            System.out.println("│  █    Jumper       │  0) Numbers");
            System.out.println("│  @    Exit Portal  │  1) Jump RIGHT");
            System.out.println("│  $    Fuel         │  2) Jump LEFT ");
            System.out.println("│  #    Web          │  3) Skip Turn");
            System.out.println("│  ^^   Freeze       │  4) Exit");
            System.out.println("└--------------------┘");
            return;
        }

        System.out.println("┎-------LEGEND-------┒  ");
        System.out.println("│  █    Jumper       │  You have lost a turn!!");
        System.out.println("│  @    Exit Portal  │");
        System.out.println("│  $    Fuel         │");
        System.out.println("│  #    Web          │");
        System.out.println("│  ^^   Freeze       │");
        System.out.println("└--------------------┘");
    }



    public static void invalidInput()
    {
        System.out.println("Invalid Input! Please try again.");
    }



}
