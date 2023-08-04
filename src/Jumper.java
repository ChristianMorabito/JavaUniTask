/**
 * This class is the main driver class which holds the main method.
 * @author Christian Morabito
 * @version ver 1.0.0
 */
public class Jumper
{
    /**
     * This is the main method which begins the program execution
     * @param    args    An array of string passed in as command line parameters
     */
    public static void main(String[] args)
    {
        Log log = new Log();
        Count count = new Count();
        State state = new State();
        Input input = new Input(state);
        Player player = new Player();
        Data data = new Data();
        Charge charge = new Charge();
        data.define(FileIO.read(Values.READ_FILE));
        Print.clearScreen();
        Print.title();
        input.usernameInput();

        while (state.isGameRunning())
        {
            Web.turnOff(state);
            data.shuffle(count);
            Web.check(state, data.getWeb(), player.getCurrentPos(), log);
            player.set(data.getBuildings());
            charge.passiveCheck(state, count.getFuelMove(), player.getCurrentPos(), data.getFuel(), log);
            count.setHeight_1(data.getBuildings().get(player.getCurrentPos()));
            Frozen.check(state, data.getFreeze(), player.getCurrentPos(), log);
            state.freezeOnExitCheck(data.getFreeze());
            state.exitCheck(player.getCurrentPos());
            do
            {
                if (state.isGameRunning())
                {
                    Print.inGameAll(charge, state, count, data, player);
                    data.fuelCollect(player.getCurrentPos());
                    input.inputAction();
                    input.action(count, log, data.getFreeze(), data.getBuildings(), player);
                }
            }
            while (state.isOutOfRange() || state.isNumLoop() || state.isExitFrozeLoop());
            Frozen.turningOff(state);
            count.setHeight_2(data.getBuildings().get(player.getCurrentPos()));
            charge.activeCheck(state, count, player.getCurrentPos(), data.getFuel(), log);
        }
        Print.exit(charge.getAmount(), input.getName(), state.isExit(), state.isWebbed());
        FileIO.write(log.display(), input.getName());
    }
}
