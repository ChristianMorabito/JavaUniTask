/**
 * Class which
 * @author Christian Morabito
 * @version ver1.0.0
 */
public class Web extends Conflict
{
    /**
     * @param log
     */
    @Override
    public void logCount(Log log)
    {
        log.setWebCount(log.getWebCount() + 1);
    }
}
