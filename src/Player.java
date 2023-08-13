import java.util.ArrayList;

/**
 * Class which holds player position values, i.e.
 * current position, previous position, & the potential
 * jump positions on the left & right sides.
 * @author Christian Morabito
 * @version ver1.0.0
 */
public class Player
{
    private int currentPos;
    private int leftPos;
    private int rightPos;
    private int previousPos;

    /**
     * Default Constructor for Player class
     */
    public Player()
    {
        currentPos = 0;
        leftPos = 0;
        rightPos = 0;
        previousPos = 0;
    }

    /**
     * Non-default constructor for Player class
     * @param currentPos accepts int for player's current position
     */
    public Player(int currentPos)
    {
        this.currentPos = currentPos;
        leftPos = 0;
        rightPos = 0;
        previousPos = 0;
    }

    /**
     * display method to print the state
     * of the class fields
     */
    public void display()
    {
        System.out.println("current position: " + currentPos + "\n" +
                "left position: " + leftPos + "\n" +
                "right position: " + rightPos + "\n" +
                "previous position: " + previousPos);
    }

    /**
     * accessor method for int currentPos
     * @return returns int currentPos
     */
    public int getCurrentPos()
    {
        return currentPos;
    }

    /**
     * accessor method for int leftPos
     * @return returns int leftPos
     */
    public int getLeftPos()
    {
        return leftPos;
    }

    /**
     * accessor method for int rightPos
     * @return returns int rightPos
     */
    public int getRightPos()
    {
        return rightPos;
    }

    /**
     * Accessor method for previousPosition
     * @return returns previousPosition: int
     */
    public int getPreviousPos()
    {
        return previousPos;
    }

    /**
     * This main method is only for the test strategy
     * @param    args    An array of string passed in as command line parameters
     */
    public static void main(String[] args)
    {
        Player player = new Player();
        player.setCurrentPos(5);
        player.setLeftPos(4);
        player.setRightPos(3);
        player.setPreviousPos(2);
        System.out.println(("Current position: " + player.getCurrentPos()));
        System.out.println(("Previous position: " + player.getPreviousPos()));
        System.out.println(("Left Position: " + player.getLeftPos()));
        System.out.println(("Right position: " + player.getRightPos()));
    }

    /**
     * method that increments or decrements currPos, updates previousPos,
     * and updates input flags if necessary
     * @param inputFlag accepts InputFlag object
     * @param freeze accepts freeze arraylist (boolean)
     * @param heights accepts heights arraylist (integer)
     * @param input accepts input int
     */
    public void move(InputFlag inputFlag, ArrayList<Boolean> freeze, ArrayList<Integer> heights, int input)
    {
        try
        {
            int temp = currentPos;
            switch (input)
            {
                case 1 ->
                {
                    temp += heights.get(currentPos);
                    if (temp <= Values.getEndIndex())
                    {
                        if (temp == Values.getEndIndex() && freeze.get(Values.getEndIndex()))
                        {
                            inputFlag.setExitFrozeLoop(true);
                            return;
                        }
                        previousPos = currentPos;
                    }
                    else
                    {
                        inputFlag.setOutOfRange(true);
                        return;
                    }
                }
                case 2 ->
                {
                    temp -= heights.get(currentPos);
                    if (temp >= Values.START_INDEX)
                    {
                        previousPos = currentPos;
                    }
                    else
                    {
                        inputFlag.setOutOfRange(true);
                        return;
                    }
                }
                case 3 ->
                {
                    previousPos = currentPos;
                }
                default ->
                {
                    Print.invalidInput(inputFlag);
                    System.exit(-1);
                }
            }
            currentPos = temp;
            inputFlag.setOutOfRange(false);
            inputFlag.setExitFrozeLoop(false);
        }
        catch (NullPointerException nullPointerException)
        {
            System.out.println(nullPointerException.getMessage());
        }

    }

    /**
     * mutator method to set both leftPos & rightPos together
     * based on player's current position on the buildingheights arraylist
     * @param heights accepts heights arraylist.
     */
    public void potentialPos(ArrayList<Integer> heights)
    {
        if (Validation.positionInput(currentPos)) return;

        int temp = currentPos;
        temp -= heights.get(currentPos);
        temp = temp >= Values.START_INDEX ? temp : -1;
        this.leftPos = temp;

        temp = currentPos;
        temp += heights.get(currentPos);
        temp = temp <= Values.getEndIndex() ? temp : -1;
        this.rightPos = temp;
    }

    /**
     * mutator method for currentPos
     * @param currentPos accepts currentPos int
     */
    public void setCurrentPos(int currentPos)
    {
        this.currentPos = currentPos;
    }

    /**
     * mutator method to set left position int
     * @param leftPos accepts int leftPos
     */
    public void setLeftPos(int leftPos)
    {
        this.leftPos = leftPos;
    }

    /**
     * Mutator method for previousPosition
     * @param previousPos used to update the previousPosition: int
     */
    public void setPreviousPos(int previousPos)
    {
        this.previousPos = previousPos;
    }

    /**
     * mutator method to set rightPos int
     * @param rightPos accepts int rightPos
     */
    public void setRightPos(int rightPos)
    {
        this.rightPos = rightPos;
    }
}

