/**
 * Class which
 * @author Christian Morabito
 * @version ver1.0.0
 */
public class Web extends Conflict
{

    public Web()
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
     * @param log
     */
    @Override
    public void logCount(Log log)
    {
        log.setWebCount(log.getWebCount() + 1);
    }
}
