/**
 * Class which stores & changes/increments 'game state' integers.
 * @author Christian Morabito
 * @version ver1.0.0
 */
public class Count
{
    private int fuelShuffleCount;
    private int previousPosition;
    private int height_1;
    private int height_2;

    /**
     * Default constructor which creates the object of the class Count.
     */
    public Count()
    {
        height_2 = 0;
        height_1 = 0;
        previousPosition = 0;
        fuelShuffleCount = 0;
    }

    /**
     * Non-Default constructor which creates the object of the class Count.
     *
     * @param height_1              Accepts an int for first building height
     * @param previousPosition      Accepts int to initialise jumper's previous position
     * @param height_2              Accepts an int for previous building height
     * @param fuelShuffleCount      Accepts int to initialise fuelShuffleCount
     */
    public Count(int height_1, int previousPosition, int height_2, int fuelShuffleCount)
    {
        this.height_1 = height_1;
        this.previousPosition = previousPosition;
        this.height_2 = height_2;
        this.fuelShuffleCount = fuelShuffleCount;
    }

    /**
     * Checks if fuelShuffleCount is modulo 3 or not.
     * @return  Returns a boolean that determines if the fuel array should be shuffled
     * or not.
     */
    public boolean fuelShuffleCheck()
    {
        return fuelShuffleCount >= 0 && fuelShuffleCount % 3 == 0;
    }

    /**
     * Accessor method for fuelShuffleCount
     * @return returns fuelShuffleCount: int
     */
    public int getFuelShuffleCount()
    {
        return fuelShuffleCount;
    }

    /**
     * Accessor method for previousPosition
     * @return returns previousPosition: int
     */
    public int getPreviousPosition()
    {
        return previousPosition;
    }

    /**
     * Accessor method for height_1
     * @return returns height_1: int
     */
    public int getHeight_1()
    {
        return height_1;
    }

    /**
     * Accessor method for height_2
     * @return returns height_2: int
     */
    public int getHeight_2()
    {
        return height_2;
    }


    /**
     * Mutator method for fuelShuffleCount
     * @param fuelShuffleCount used to update the fuelShuffleCount: int, through incrementation.
     */
    public void setFuelShuffleCount(int fuelShuffleCount)
    {
        this.fuelShuffleCount = fuelShuffleCount;
    }

    /**
     * Mutator method for previousPosition
     * @param previousPosition used to update the previousPosition: int
     */
    public void setPreviousPosition(int previousPosition)
    {
        this.previousPosition = previousPosition;
    }

    /**
     * Mutator method for height_2
     * @param height_2 used to update height_2: int
     */
    public void setHeight_2(int height_2)
    {
        this.height_2 = height_2;
    }

    /**
     * Mutator method for height_1
     * @param height_1 used to update height_1: int
     */
    public void setHeight_1(int height_1)
    {
        this.height_1 = height_1;
    }
}