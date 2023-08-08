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
        Web web = new Web();
        Ice ice = new Ice();
        Log log = new Log();
        State state = new State();
        Input input = new Input();
        Player player = new Player();
        Data data = new Data();
        Charge charge = new Charge();
        data.define(FileIO.read(Values.READ_FILE));
        Print.clearScreen();
        Print.title();
        input.usernameInput();

        while (state.isGameRunning())
        {
            web.setStatus(false);
            data.shuffle();
            web.check(data.getWeb(), player.getCurrentPos(), log);
            player.set(data.getBuildings());
            charge.passiveCheck(web.isStatus(), state, data.getFuelMove(), player.getCurrentPos(), data.getFuel(), log);
            charge.setHeight1(data.getBuildings().get(player.getCurrentPos()));
            ice.check(data.getFreeze(), player.getCurrentPos(), log);
            state.freezeOnExitCheck(data.getFreeze());
            state.exitCheck(player.getCurrentPos(), ice.isStatus());
            do
            {
                if (state.isGameRunning())
                {
                    Print.inGameAll(ice.isStatus(), web.isStatus(), charge, state, data, player);
                    data.fuelCollect(player.getCurrentPos());
                    input.inputAction(ice.isStatus());
                    input.action(state, ice.isStatus(), log, data.getFreeze(), data.getBuildings(), player);
                }
            }
            while (Validation.innerLoop(state));
            ice.setStatus(false);
            charge.setHeight2(data.getBuildings().get(player.getCurrentPos()));
            charge.activeCheck(player, data, state, player.getCurrentPos(), data.getFuel(), log);
        }
        Print.exit(charge.getAmount(), input.getName(), state.isExit(), web.isStatus());
        FileIO.write(Values.WRITE_FILE, log.display(), input.getName());
    }
}
