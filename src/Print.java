import java.util.ArrayList;
import java.util.Arrays;

/**
 * Utility class which provides print methods
 * @author Christian Morabito
 * @version ver1.0.0
 */
public class Print
{
    /**
     * Method prints legend & action options
     * the print dynamically changes based on if player is frozen or exit is frozen
     * froz
     * @param isFrozen accepts boolean which determines if player is frozen or not
     * @param inputFlag accepts inputflag object
     * @param rightPos accepts int which represents potential rightPosition
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
        final String froze_1 = "1̶)̶ ̶J̶u̶m̶p̶ ̶R̶I̶G̶H̶T̶ ❌";
        final String input_2 = "2) Jump LEFT  ✅";
        final String froze_2 = "2̶)̶ ̶J̶u̶m̶p̶ ̶L̶E̶F̶T̶  ❌";
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
     * Method to print player charge amount in charge blocks
     * @param amount accepts int for charge amount
     * @param numbers accepts boolean which determines if numbers option is on/off.
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
     * method to clear screen.
     */
    public static void clearScreen()
    {
        // reference: https://stackoverflow.com/questions/2979383/how-to-clear-the-console-using-java
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    /**
     * Method to print exit msg after game ends.
     * Msg varies based on whether player won or lost
     * @param charge accepts charge int, so player knows if they won on minimal charge
     * @param mainFlag accepts mainflag object
     * @param name accepts player name string
     * @param webbed accepts boolean determining if player lost whilst webbed
     */
    public static void exit(int charge, MainFlag mainFlag, String name, boolean webbed)
    {
        boolean exit = mainFlag.isExit();
        boolean wonGame = mainFlag.isWonGame();
        if (!exit)
        {
            if (wonGame)
            {
                float percentage = (float) charge / Values.MAX_CHARGE * 100;
                String percentageString = String.format("%.00f", percentage);
                String emphasis = charge < 2 ? "ONLY " : "";
                System.out.println("Congratulations, " + name + "! You have escaped the Nowhere Dimension with "
                        + emphasis + percentageString + "% charge remaining!!");
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
     * method that prints msg that player cannot make exit jump because portal
     * is frozen
     * @param inputFlag accepts inputFlag object
     * @param rightPosition accepts rightPosition int
     */
    public static void frozenExit(InputFlag inputFlag, int rightPosition)
    {
        if (Validation.freezeOnExit(inputFlag, rightPosition))
        {
            System.out.println("\uD83D\uDEA8 WARNING!! EXIT PORTAL FROZEN \uD83D\uDEA8");
        }
    }

    /**
     * method that prints if fuel has been collected. It will also print if max fuel amount has been
     * received
     * @param fuelArray accepts arraylist (boolean) that holds fuelArray
     * @param currentPos accepts int which represents current position
     * @param chargeCount accept int which represents charge amount
     */
    public static void fuelCollected(ArrayList<Boolean> fuelArray, int currentPos, int chargeCount)
    {
        if (fuelArray.get(currentPos))
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
     * Method that prints if fuel is respawning next turn
     * @param fuelShuffleCheck accepts boolean fuelShuffleCheck
     */
    public static void fuelRespawning(boolean fuelShuffleCheck)
    {
        if (fuelShuffleCheck)
        {
            System.out.println("\uD83D\uDEA8 FUEL RESPAWNING \uD83D\uDEA8");
        }
    }

    /**
     * Method which implicitly creates temporary graphic object,
     * then formats & prints it.
     * @param array accepts array object
     * @param currentPosition accepts current position int
     * @param leftPosition accepts potential left position int
     * @param rightPosition accepts potential right position int
     * @param numbers accepts boolean that determines if numbers is on/off
     */
    public static void graphic(Array array, int currentPosition, int leftPosition,
                               int rightPosition, boolean numbers)
    {
        StringBuilder[][] buildingString = new Graphic().create(array,
                currentPosition,leftPosition, rightPosition, numbers);

        System.out.println();
        for (int i = 0; i < Values.getMaxHeight() + 1; i++)
        {
            String arrayToString = Arrays.toString(buildingString[i])
                    .replace(",", "")
                    .replace("[", "")
                    .replace("]", "");
            System.out.println(arrayToString);
        }
    }

    /**
     * Method that prints msg if player is frozen
     * @param isFrozen accepts boolean isFrozen
     */
    public static void ice(boolean isFrozen)
    {
        if (isFrozen)
        {
            System.out.println("\uD83D\uDEA8 YOU ARE FROZEN \uD83D\uDEA8");
        }
    }

    /**
     * Method that conveniently prints all in-game print methods in one
     * @param isFrozen accepts boolean which determines if player is frozen
     * @param isWebbed accepts boolean which determines if player is webbed
     * @param charge accepts charge object
     * @param inputFlag accepts inputFlag object
     * @param array accepts array object
     * @param player accepts player object
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
     * method that prints only if player enters an invalid input
     * @param inputFlag accepts inputFlag object
     */
    public static void invalidInput(InputFlag inputFlag)
    {
        if (inputFlag.isInvalidInput() || inputFlag.isExitFrozeLoop())
        {
            System.out.println("\uD83D\uDEA8 INVALID INPUT! Retry \uD83D\uDEA8");
        }
    }




    /**
     * method that prints only if player is out of range
     * @param inputFlag accepts inputFlag object
     */
    public static void outOfRange(InputFlag inputFlag)
    {
        if (inputFlag.isOutOfRange()) {
            System.out.println("\uD83D\uDEA8 BEYOND RANGE! Retry \uD83D\uDEA8");
        }
    }

    /**
     * method prints the title & text.
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
     * method that only prints if player is webbed
     * @param isWebbed accepts boolean
     */
    public static void web(boolean isWebbed)
    {
        if (isWebbed) {
            System.out.println("\uD83D\uDEA8 YOU ARE WEBBED!! \uD83D\uDEA8");
        }
    }
}
