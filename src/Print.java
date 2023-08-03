import java.util.ArrayList;
import java.util.Arrays;

public class Print
{

    public static void title()
    {

        System.out.println("""
                     
                     ██╗ █████╗ ██╗   ██╗ █████╗          ██╗██╗   ██╗███╗   ███╗██████╗ ███████╗██████╗
                     ██║██╔══██╗██║   ██║██╔══██╗         ██║██║   ██║████╗ ████║██╔══██╗██╔════╝██╔══██╗
                     ██║███████║██║   ██║███████║         ██║██║   ██║██╔████╔██║██████╔╝█████╗  ██████╔╝
                ██   ██║██╔══██║╚██╗ ██╔╝██╔══██║    ██   ██║██║   ██║██║╚██╔╝██║██╔═══╝ ██╔══╝  ██╔══██╗
                ╚█████╔╝██║  ██║ ╚████╔╝ ██║  ██║    ╚█████╔╝╚██████╔╝██║ ╚═╝ ██║██║     ███████╗██║  ██║
                 ╚════╝ ╚═╝  ╚═╝  ╚═══╝  ╚═╝  ╚═╝     ╚════╝  ╚═════╝ ╚═╝     ╚═╝╚═╝     ╚══════╝╚═╝  ╚═╝
              ┎───────────────────────────────────────────────────────────────────────────────────────────┒
              ┃                                   WELCOME TO NOWHERE                                      ┃                 
              ┃                                ...where no one escapes!                                   ┃     
              ┃    □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □    ┃   
              ┃     You are quested to try & escape using the only jumper device available in Nowhere     ┃                                     
              ┃                       Remember the following to ensure you survive:                       ┃ 
              ┃                      - the device allows for jumping short distances                      ┃                 
              ┃                      - building heights change frequently.                                ┃     
              ┃                      - fuel cells can refuel the device.                                  ┃                     
              ┃                      - stay far away from frozen buildings.                               ┃     
              ┃                      - look out from the Nowhere police webs.                             ┃         
              ┖───────────────────────────────────────────────────────────────────────────────────────────┚                 
                """); // reference: https://patorjk.com/software/taag/#p=display&f=Graffiti&t=Type%20Something%20
    }

    public static void action(State state, int rightPosition)
    {
        String turnLost = "You have lost a turn!!";
        String legend_1 = "┎-------LEGEND-------┒";
        String legend_2 = "│  " + Values.JUMPER + "    Jumper       │";
        String legend_3 = "│  " + Values.PORTAL + "    Exit Portal  │";
        String legend_4 = "│  " + Values.FUEL_CELL + "    Fuel         │";
        String legend_5 = "│  " + Values.WEB + "    Web          │";
        String legend_6 = "│  " + Values.FREEZE + "    Freeze       │";
        String legend_7 = "└--------------------┘";
        String input_1 = "Enter a number between 0 & 4:";
        String input_2 = "0) Numbers";
        String input_3 = "1) Jump RIGHT";
        String freeze_3 = "1̶)̶ ̶J̶u̶m̶p̶ ̶R̶I̶G̶H̶T̶";
        String input_4 = "2) Jump LEFT ";
        String input_5 = "3) Skip Turn";
        String input_6 = "4) Exit";

        System.out.println();
        if (!state.isFrozen())
        {
            System.out.println(legend_1 + " " + input_1);
            System.out.println(legend_2 + " " + input_2);
            System.out.println(legend_3 + " " + (Validation.freezeOnExit(state, rightPosition) ? freeze_3 : input_3));
            System.out.println(legend_4 + " " + input_4);
            System.out.println(legend_5 + " " + input_5);
            System.out.println(legend_6 + " " + input_6);
            System.out.println(legend_7);

            return;
        }
        System.out.println(legend_1);
        System.out.println(legend_2);
        System.out.println(legend_3);
        System.out.println(legend_4 + " " + turnLost);
        System.out.println(legend_5);
        System.out.println(legend_6);
        System.out.println(legend_7);
    }

    public static void cannotJumpFrozenExit(State state)
    {
        if (state.isExitFrozeLoop())
        {
            System.out.println("\uD83D\uDEA8 CANNOT JUMP RIGHT \uD83D\uDEA8");
        }
    }
    public static void chargeAmount(int amount, boolean numbers)
    {
        String chargeNumber = numbers ? String.valueOf(amount) : "";
        String chargeBlock = "█ ".repeat(amount);
        System.out.println();
        System.out.println("Charge: " + chargeBlock + chargeNumber);
        System.out.println();
    }

    public static void clearScreen()
    {
        // reference: https://stackoverflow.com/questions/2979383/how-to-clear-the-console-using-java
        System.out.print("\033[H\033[2J");
        System.out.flush();
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

    public static void frozen(State state)
    {
        if (state.isFrozen())
        {
            System.out.println("\uD83D\uDEA8 YOU ARE FROZEN \uD83D\uDEA8");
        }
    }
    public static void frozenExit(State state, int rightPosition)
    {
        if (Validation.freezeOnExit(state, rightPosition))
        {
            System.out.println("\uD83D\uDEA8 WARNING!! EXIT PORTAL FROZEN \uD83D\uDEA8");
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

    public static void fuelRespawning(boolean fuelShuffleCheck)
    {
        if (fuelShuffleCheck)
        {
            System.out.println("\uD83D\uDEA8 FUEL RESPAWNING \uD83D\uDEA8");
        }
    }

    public static void graphic(Array array, int currentPosition, int leftPosition,
                               int rightPosition, boolean numbers)
    {
        StringBuilder[][] buildingString = new Graphic().create(array,
                currentPosition,leftPosition, rightPosition, numbers);

        System.out.println();
        for (int i = 0; i < Values.getMaxHeight() + 1; i++)
        {
            String formattedString = Arrays.toString(buildingString[i])
                    .replace(",", "")
                    .replace("[", "")
                    .replace("]", "");
            System.out.println(formattedString);
        }
    }

    public static void inGameAll(Charge charge, State state, Count count, Array array, Player player)
    {
        // clearScreen();
        chargeAmount(charge.getAmount(), state.isNumbers());
        frozen(state);
        web(state);
        frozenExit(state, player.getRightPos());
        outOfRange(state);
        cannotJumpFrozenExit(state);
        fuelRespawning(count.fuelShuffleCheck());
        fuelCollected(array.getFuel(), player.getCurrentPos(), charge.getAmount());
        graphic(array, player.getCurrentPos(), player.getLeftPos(),
                player.getRightPos(), state.isNumbers());
        action(state, player.getRightPos());
    }
    public static void invalidInput()
    {
        System.out.println("Invalid Input! Please try again.");
    }

    public static void outOfRange(State state)
    {
        if (state.isOutOfRange()) {
            System.out.println("\uD83D\uDEA8 BEYOND RANGE: Retry \uD83D\uDEA8");
        }
    }

    public static void web(State state)
    {
        if (state.isWebbed()) {
            System.out.println("\uD83D\uDEA8 YOU ARE WEBBED!! \uD83D\uDEA8");
        }
    }
}

