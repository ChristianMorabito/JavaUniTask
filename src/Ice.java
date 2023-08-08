import java.util.ArrayList;

public class Ice extends Conflict
{
    @Override
    public void logCount(Log log)
    {
        log.setFreezeCount(log.getFreezeCount() + 1);
    }
}