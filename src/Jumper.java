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
        Array array = new Array();
        Charge charge = new Charge();
        FileIO fileIO = new FileIO();
        fileIO.read();
        array.define(fileIO.getData());
        Print.clearScreen();
        Print.title();
        input.usernameInput();

        while (state.isGameRunning())
        {
            Web.turnOff(state);
            array.shuffle(count);
            Web.check(state, array.getWeb(), player.getCurrentPos(), log);
            player.set(array.getBuildings());
            charge.passiveCheck(state, count.getFuelMove(), player.getCurrentPos(), array.getFuel(), log);
            count.setHeight_1(array.getBuildings().get(player.getCurrentPos()));
            Frozen.check(state, array.getFreeze(), player.getCurrentPos(), log);
            state.freezeOnExitCheck(array.getFreeze());
            state.exitCheck(player.getCurrentPos());
            do
            {
                if (state.isGameRunning())
                {
                    Print.inGameAll(charge, state, count, array, player);
                    array.fuelCollect(player.getCurrentPos());
                    input.inputAction();
                    input.action(count, log, array.getFreeze(), array.getBuildings(), player);
                }
            }
            while (state.isOutOfRange() || state.isNumLoop() || state.isExitFrozeLoop());
            Frozen.turningOff(state);
            count.setHeight_2(array.getBuildings().get(player.getCurrentPos()));
            charge.activeCheck(state, count, player.getCurrentPos(), array.getFuel(), log);
        }
        Print.exit(charge.getAmount(), input.getName(), state.isExit(), state.isWebbed());
        fileIO.write(log.display(), input.getName());
    }
}
