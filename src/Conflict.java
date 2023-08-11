import java.util.ArrayList;

/**
 * Abstract Class to instantiate Web & Ice classes.
 * Both classes are identical, hence why inheritance to avoid code repetition
 * @author Christian Morabito
 * @version ver1.0.0
 */
public abstract class Conflict
{
    private boolean status;


    /**
     * Default constructor to instantiate Web/Ice classes.
     */
    public Conflict()
    {
        status = false;
    }

    /**
     * Non-Default constructor to instantiate Web/Ice classes.
     * @param status accepts boolean for 'status' field.
     */
    public Conflict(boolean status)
    {
        this.status = status;
    }

    /**
     * @param conflictArray accepts either web or freeze arraylists (boolean)
     * @param currentPos accepts int which represents player's current position
     * @param log accepts Log object
     */
    public void check(ArrayList<Boolean> conflictArray, int currentPos, Log log)
    {
        if (conflictArray.get(currentPos))
        {
            status = true;
            logCount(log);
        }
        else
        {
            status = false;
        }
    }

    /**
     * display method to print the state
     * of the class fields
     */
    public void display()
    {
        System.out.println("status is " + status);
    }


    /**
     * Accessor method for 'status' boolean
     * @return returns 'status' boolean
     */
    public boolean isStatus()
    {
        return status;
    }

    /**
     * Abstract method for polymorphism.
     * @param log accepts Log object
     */
    public abstract void logCount(Log log);


    /**
     * Mutator method for 'status' boolean
     * @param status accepts boolean value to set 'status' field.
     */
    public void setStatus(boolean status)
    {
        this.status = status;
    }
}
