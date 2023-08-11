import java.util.ArrayList;

/**
 * Utility class which provides methods for validating
 * @author Christian Morabito
 * @version ver1.0.0
 */
public class Validation
{
    /**
     * validates int length based on two ranges
     * @param integer accepts the int to be validated
     * @param lessThan1 accepts lessThan1 int parameter
     * @param greaterThan1 accepts greaterThan1 int parameter
     * @param lessThan2 accepts lessThan2 int parameter
     * @param greaterThan2 accepts greaterThan2 int parameter
     * @return returns boolean
     */
    public static boolean betweenRanges(int integer, int lessThan1, int greaterThan1, int lessThan2, int greaterThan2)
    {
        return integer < lessThan1 || integer > greaterThan1 && integer < lessThan2 || integer > greaterThan2;
    }

    /**
     * method checks that all columns are the same length
     * @param datumLength accepts int which represents row length
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
     * Method to ensure that only 1 exit is in the game
     * @param exitArray accepts exitArray arraylist (boolean)
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
     * method that returns boolean if freeze is on exit & player is in jump range
     * @param inputFlag accepts input flag to check if exit is frozen
     * @param rightPosition accepts int to see if player's potential jump is on exit
     * @return returns boolean
     */
    public static boolean freezeOnExit(InputFlag inputFlag, int rightPosition)
    {
        return inputFlag.isFrozenExit() && rightPosition == Values.getEndIndex();
    }

    /**
     * method that returns true if fuel count is % 3
     * @param fuelShuffleCount accepts int that is fuelShuffleCount
     * @return returns boolean
     */
    public static int fuelShuffleModulo(int fuelShuffleCount)
    {
        return fuelShuffleCount % Values.FUEL_UPDATE_COUNT;
    }

    /**
     * checks the state of all inputFlag fields
     * @param inputFlag accepts all inputFlag fields
     * @return returns boolean
     */
    public static boolean innerLoop(InputFlag inputFlag)
    {
        return inputFlag.isOutOfRange() || inputFlag.isNumbersLoop() ||
                inputFlag.isExitFrozeLoop() || inputFlag.isInvalidInput();
    }

    /**
     * validates int length based on range
     * @param integer accepts the int to be validated
     * @param lessThan accepts lessThan int parameter
     * @param greaterThan accepts greaterThan int parameter
     * @return returns boolean
     */
    public static boolean integerLength(int integer, int lessThan, int greaterThan)
    {
        return integer < lessThan || integer > greaterThan;
    }

    /**
     * method that checks if building height is
     * above min height value
     */
    public static void minHeightCheck(int height)
    {
        if (height < Values.MIN_HEIGHT)
        {
            System.out.println("Building height too low in " + Values.READ_FILE);
            System.out.println("Exiting...");
            System.exit(-1);
        }
    }

    /**
     * Method that checks if player is on exit building
     * @param currentPos accepts int that represents player's current position
     * @return returns boolean
     */
    public static boolean onExit(int currentPos)
    {
        return currentPos == Values.getEndIndex();
    }

    /**
     * method that checks if player's position is in valid range
     * @return returns boolean
     */
    public static boolean positionInput(int currentPos)
    {
        return currentPos > Values.getRowsAmount() || currentPos < 0;
    }

    /**
     * method that validates if there are
     * enough rows in the text file
     */
    public static void rowLengthCheck()
    {
        if (Values.getRowsAmount() < Values.MIN_ROW_LENGTH)
        {
            System.out.println("Not enough rows in " + Values.READ_FILE);
            System.out.println("Exiting...");
            System.exit(-1);
        }
    }

    /**
     * Checks if string is in valid range
     * @param name accepts string input
     * @param lessThan accepts int representing lessThan
     * @param greaterThan accepts int representing greaterThan
     * @return returns boolean
     */
    public static boolean stringRange(String name, int lessThan, int greaterThan)
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
     * method that converts string to boolean & exits program if unable to
     * @param string accepts string to be converted to boolean
     * @return returns boolean (that's been converted from string)
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
     * method that converts string to int & exits program if number
     * format exception
     * @param string accepts string to be converted to int
     * @return returns int (that's been converted from string)
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



}
