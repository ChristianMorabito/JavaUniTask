public class Web extends Conflict
{
    @Override
    public void logCount(Log log)
    {
        log.setWebCount(log.getWebCount() + 1);
    }
}
