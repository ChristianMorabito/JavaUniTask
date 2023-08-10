import java.util.ArrayList;
import java.util.Arrays;

/**
 * Class which
 * @author Christian Morabito
 * @version ver1.0.0
 */
public class Print
{

    /**
     *
     */
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
              ┃                      - stay far away from ice buildings.                                  ┃     
              ┃                      - look out from the Nowhere police webs.                             ┃         
              ┖───────────────────────────────────────────────────────────────────────────────────────────┚                 
                """); // reference: https://patorjk.com/software/taag/#p=display&f=Graffiti&t=Type%20Something%20
    }

    /**
     * @param isFrozen
     * @param inputFlag
     * @param rightPos
     */
    public static void action(boolean isFrozen, InputFlag inputFlag, int rightPos)
    {
        final String limitedMovement = "LIMITED MOVEMENT!!";
        final String legend_1 = "┎-------LEGEND-------┒";
        final String legend_2 = "│  " + Values.JUMPER + "    Jumper       │";
        final String legend_3 = "│  " + Values.PORTAL + "    Exit Portal  │";
        final String legend_4 = "│  " + Values.FUEL_CELL + "    Fuel         │";
        final String legend_5 = "│  " + Values.WEB + "    Web          │";
        final String legend_6 = "│  " + Values.FREEZE + "    Freeze       │";
        final String legend_7 = "└--------------------┘";
        final String standard = "Enter a number between 0 & 4:";
        final String input_0 = "0) Numbers";
        final String input_1 = "1) Jump RIGHT ✅";
        final String froze_1 = "1) Jump RIGHT ❌";
        final String input_2 = "2) Jump LEFT  ✅";
        final String froze_2 = "2) Jump LEFT  ❌";
        final String input_3 = "3) Skip Turn  ✅";
        final String input_4 = "4) Exit";

        System.out.println();
        System.out.println(legend_1 + " " + (Validation.freezeOnExit(inputFlag, rightPos) || isFrozen ?
                limitedMovement : standard));
        System.out.println(legend_2 + " " + input_0);
        System.out.println(legend_3 + " " + (Validation.freezeOnExit(inputFlag, rightPos) || isFrozen ?
                froze_1 : input_1));
        System.out.println(legend_4 + " " + (isFrozen ? froze_2 : input_2));
        System.out.println(legend_5 + " " + input_3);
        System.out.println(legend_6 + " " + input_4);
        System.out.println(legend_7);

    }

    /**
     * @param amount
     * @param numbers
     */
    public static void chargeAmount(int amount, boolean numbers)
    {
        String chargeNumber = numbers ? String.valueOf(amount) : "";
        String chargeBlock = "█ ".repeat(amount);
        System.out.println();
        System.out.println("Charge: " + chargeBlock + chargeNumber);
        System.out.println();
    }

    /**
     *
     */
    public static void clearScreen()
    {
        // reference: https://stackoverflow.com/questions/2979383/how-to-clear-the-console-using-java
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    /**
     * @param charge
     * @param mainFlag
     * @param name
     * @param webbed
     */
    public static void exit(int charge, MainFlag mainFlag, String name, boolean webbed)
    {
        boolean exit = mainFlag.isExit();
        boolean wonGame = mainFlag.isWonGame();
        if (!exit)
        {
            if (wonGame)
            {
                int chargePercentage = charge / Values.MAX_CHARGE;
                String emphasis = charge < 2 ? "ONLY " : "";
                System.out.println("Congratulations, " + name + "! You have escaped the Nowhere Dimension with "
                        + emphasis + charge + "% charge remaining!!");
            }
            else
            {
                String webbedString = webbed ? "were WEBBED which " : "";
                System.out.println("Oh no, " + name + "! You " + webbedString +
                        "drained your fuel! You remain trapped in the Nowhere Dimension!! ");
            }
        }
        System.out.println("--GAME OVER--");
    }

    /**
     * @param isFrozen
     */
    public static void ice(boolean isFrozen)
    {
        if (isFrozen)
        {
            System.out.println("\uD83D\uDEA8 YOU ARE FROZEN \uD83D\uDEA8");
        }
    }

    /**
     * @param inputFlag
     * @param rightPosition
     */
    public static void frozenExit(InputFlag inputFlag, int rightPosition)
    {
        if (Validation.freezeOnExit(inputFlag, rightPosition))
        {
            System.out.println("\uD83D\uDEA8 WARNING!! EXIT PORTAL FROZEN \uD83D\uDEA8");
        }
    }

    /**
     * @param fuelArray
     * @param currentSpot
     * @param chargeCount
     */
    public static void fuelCollected(ArrayList<Boolean> fuelArray, int currentSpot, int chargeCount)
    {
        if (fuelArray.get(currentSpot))
        {
            if (chargeCount == Values.MAX_CHARGE)
            {
                System.out.println("✅✅ MAX FUELED ✅✅");
                return;
            }
            System.out.println("✅ FUELED ✅");
        }
    }

    /**
     * @param fuelShuffleCheck
     */
    public static void fuelRespawning(boolean fuelShuffleCheck)
    {
        if (fuelShuffleCheck)
        {
            System.out.println("\uD83D\uDEA8 FUEL RESPAWNING \uD83D\uDEA8");
        }
    }

    /**
     * @param array
     * @param currentPosition
     * @param leftPosition
     * @param rightPosition
     * @param numbers
     */
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

    /**
     * @param isFrozen
     * @param isWebbed
     * @param charge
     * @param inputFlag
     * @param array
     * @param player
     */
    public static void inGameAll(boolean isFrozen, boolean isWebbed, Charge charge, InputFlag inputFlag, Array array, Player player)
    {
        clearScreen();
        chargeAmount(charge.getAmount(), inputFlag.isNumbers());
        invalidInput(inputFlag);
        ice(isFrozen);
        web(isWebbed);
        frozenExit(inputFlag, player.getRightPos());
        outOfRange(inputFlag);
        fuelRespawning(array.fuelShuffleCheck());
        fuelCollected(array.getTempFuel(), player.getCurrentPos(), charge.getAmount());
        graphic(array, player.getCurrentPos(), player.getLeftPos(),
                player.getRightPos(), inputFlag.isNumbers());
        action(isFrozen, inputFlag, player.getRightPos());
    }

    /**
     * @param inputFlag
     */
    public static void invalidInput(InputFlag inputFlag)
    {
        if (inputFlag.isInvalidInput() || inputFlag.isExitFrozeLoop())
        {
            System.out.println("\uD83D\uDEA8 INVALID INPUT! Retry \uD83D\uDEA8");
        }
    }


    /**
     * @param inputFlag
     */
    public static void outOfRange(InputFlag inputFlag)
    {
        if (inputFlag.isOutOfRange()) {
            System.out.println("\uD83D\uDEA8 BEYOND RANGE! Retry \uD83D\uDEA8");
        }
    }

    /**
     * @param isWebbed
     */
    public static void web(boolean isWebbed)
    {
        if (isWebbed) {
            System.out.println("\uD83D\uDEA8 YOU ARE WEBBED!! \uD83D\uDEA8");
        }
    }
}
