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
        MainFlag mainFlag = new MainFlag();
        InputFlag inputFlag = new InputFlag();
        Web web = new Web();
        Ice ice = new Ice();
        Log log = new Log();
        Input input = new Input();
        Player player = new Player();
        Data data = new Data();
        Charge charge = new Charge();
        data.define(FileIO.read(Values.READ_FILE));
        Print.clearScreen();
        Print.title();
        input.usernameInput();

        while (mainFlag.isGameRunning())
        {
            data.shuffle();
            web.check(data.getWeb(), player.getCurrentPos(), log);
            player.setPotentialPositions(data.getBuildings());
            charge.passiveCheck(data, web.isStatus(), mainFlag, player.getCurrentPos(), log);
            charge.setHeight1(data.getBuildings().get(player.getCurrentPos()));
            ice.check(data.getFreeze(), player.getCurrentPos(), log);
            inputFlag.freezeOnExitCheck(data.getFreeze());
            do
            {
                if (mainFlag.isGameRunning())
                {
                    Print.inGameAll(ice.isStatus(), web.isStatus(), charge, inputFlag, data, player);
                    data.fuelCollect(player.getCurrentPos());
                    input.inputAction(ice.isStatus(), inputFlag);
                    input.action(mainFlag, inputFlag, ice, log, data.getFreeze(), data.getBuildings(), player);
                }
            }
            while (Validation.innerLoop(inputFlag));
            charge.setHeight2(data.getBuildings().get(player.getCurrentPos()));
            charge.activeCheck(player, data, mainFlag, player.getCurrentPos(), data.getFuel(), log);
            mainFlag.wonGameCheck(player.getCurrentPos(), charge.getAmount());
        }
        Print.exit(charge.getAmount(), mainFlag.isWonGame(), input.getName(), mainFlag.isExit(), web.isStatus());
        FileIO.write(Values.WRITE_FILE, log.display(), input.getName());
    }
}
