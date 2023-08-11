/**
 * Class which extends Conflict & overrides logCount method.
 * @author Christian Morabito
 * @version ver1.0.0
 */
public class Web extends Conflict
{

    /**
     * Default constructor for Web class
     */
    public Web()
    {
    }

    /**
     * method to log that player is on web
     * @param log accepts object from Log class
     */
    @Override
    public void logCount(Log log)
    {
        log.setWebCount(log.getWebCount() + 1);
    }
}
