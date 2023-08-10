/**
 * This is a subclass of Conflict abstract class.
 * @author Christian Morabito
 * @version ver1.0.0
 */
public class Ice extends Conflict
{
    public Ice()
    {
    }

    /**
     * display method to print the state
     * of the class fields
     */
    public void display()
    {
        System.out.println();
    }
    /**
     * Method that overrides Conflict class' logCount method.
     * It increments the counter for when
     * a player gets frozen which is logged.
     * @param log accepts Log object.
     */
    @Override
    public void logCount(Log log)
    {
        log.setFreezeCount(log.getFreezeCount() + 1);
    }
}