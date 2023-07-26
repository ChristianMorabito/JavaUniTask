public class Count {

    private int previousPosition;
    private int height_1;
    private int height_2;
    private int fuelShuffleCount;

    public Count()
    {
        height_2 = 0;
        height_1 = 0;
        previousPosition = 0;
        fuelShuffleCount = 0;
    }
    public Count(int height_1, int previousPosition, int height_2, int fuelShuffleCount)
    {
        this.height_1 = height_1;
        this.previousPosition = previousPosition;
        this.height_2 = height_2;
        this.fuelShuffleCount = fuelShuffleCount;
    }

    public boolean fuelShuffleCheck()
    {
        return fuelShuffleCount >= 0 && fuelShuffleCount % 3 == 0;
    }

    public int getFuelShuffleCount()
    {
        return fuelShuffleCount;
    }

    public int getPreviousPosition()
    {
        return previousPosition;
    }

    public int getHeight_1()
    {
        return height_1;
    }

    public int getHeight_2()
    {
        return height_2;
    }

    public void setFuelShuffleCount(int fuelShuffleCount)
    {
        this.fuelShuffleCount = fuelShuffleCount;
    }

    public void setPreviousPosition(int previousPosition)
    {
        this.previousPosition = previousPosition;
    }

    public void setHeight_2(int height_2)
    {
        this.height_2 = height_2;
    }
    public void setHeight_1(int height_1)
    {
        this.height_1 = height_1;
    }
}
