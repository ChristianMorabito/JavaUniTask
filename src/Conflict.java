import java.util.ArrayList;

public abstract class Conflict
{
    private boolean status = false;


    public abstract void logCount(Log log);

    public void check(ArrayList<Boolean> conflict, int currentPosition, Log log)
    {
        if (conflict.get(currentPosition))
        {
            status = true;
            logCount(log);
        }
    }

    public boolean isStatus()
    {
        return status;
    }

    public void setStatus(boolean status)
    {
        this.status = status;
    }
}
