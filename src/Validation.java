import java.util.ArrayList;

/**
 * Class which
 * @author Christian Morabito
 * @version ver1.0.0
 */
public class Validation
{

    /**
     * @param datumLength
     */
    public static void columnLengthCheck(int datumLength)
    {
        if (datumLength != Values.COLUMN_LENGTH)
        {
            System.out.println("One of the columns is of invalid length. Exiting...");
            System.exit(-1);
        }
    }

    /**
     * @param exitArray
     */
    public static void exitCheck(ArrayList<Boolean> exitArray)
    {
        int trueCount = 0;

        for (boolean bool : exitArray)
        {
            if (bool)
            {
                trueCount++;
            }
            if (trueCount > 1)
            {
                System.out.println("Too many exits found in " + Values.READ_FILE);
                System.out.println("Exiting...");
                System.exit(-1);
            }
        }
    }

    /**
     * @param inputFlag
     * @param rightPosition
     * @return
     */
    public static boolean freezeOnExit(InputFlag inputFlag, int rightPosition)
    {
        return inputFlag.isFrozenExit() && rightPosition == Values.getEndIndex();
    }

    /**
     * @param fuelShuffleCount
     * @return
     */
    public static int fuelShuffleModulo(int fuelShuffleCount)
    {
        return fuelShuffleCount % Values.FUEL_UPDATE_COUNT;
    }

    /**
     * @param currentPos
     * @return
     */
    public static boolean onExit(int currentPos)
    {
        return currentPos == Values.getEndIndex();
    }

    /**
     *
     */
    public static void rowLengthCheck()
    {
        if (Values.getRowLength() < Values.MIN_ROW_LENGTH)
        {
            System.out.println("Not enough rows in " + Values.READ_FILE);
            System.out.println("Exiting...");
            System.exit(-1);
        }
    }

    /**
     * @param string
     * @return
     */
    public static boolean stringToBoolean(String string)
    {
        if (string.equalsIgnoreCase("true") || string.equalsIgnoreCase("false"))
        {
            return Boolean.parseBoolean(string);
        }
        System.out.println("Invalid boolean found in " + Values.READ_FILE);
        System.exit(-1);
        return false;
    }

    /**
     * @param string
     * @return
     */
    public static int stringToInteger(String string)
    {
        int integer = 0;
        try
        {
            integer = Integer.parseInt(string);
        } catch (NumberFormatException nfe)
        {
            System.out.println("Number Format Exception found in " + Values.READ_FILE);
            System.out.println("Exiting...");
            System.exit(-1);
        }
        return integer;
    }

    /**
     * @param name
     * @param lessThan
     * @param greaterThan
     * @return
     */
    public static boolean stringLength(String name, int lessThan, int greaterThan)
    {
        if (name.length() < lessThan)
        {
            System.out.println("Input too SHORT. Please try again.");
            return true;
        }
        else if (name.length() > greaterThan)
        {
            System.out.println("Input too LONG. Please try again.");
            return true;
        }
        return false;
    }

    /**
     * @param integer
     * @param lessThan1
     * @param greaterThan1
     * @param lessThan2
     * @param greaterThan2
     * @return
     */
    public static boolean betweenRanges(int integer, int lessThan1, int greaterThan1, int lessThan2, int greaterThan2)
    {
        return integer < lessThan1 || integer > greaterThan1 && integer < lessThan2 || integer > greaterThan2;
    }

    /**
     * @param inputFlag
     * @return
     */
    public static boolean innerLoop(InputFlag inputFlag)
    {
        return inputFlag.isOutOfRange() || inputFlag.isNumbersLoop() ||
                inputFlag.isExitFrozeLoop() || inputFlag.isInvalidInput();
    }

    /**
     * @param integer
     * @param lessThan
     * @param greaterThan
     * @return
     */
    public static boolean integerLength(int integer, int lessThan, int greaterThan)
    {
        return integer < lessThan || integer > greaterThan;
    }

}
