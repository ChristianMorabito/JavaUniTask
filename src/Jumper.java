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
        Array array = new Array();
        Charge charge = new Charge();
        array.parse(FileIO.read(Values.READ_FILE));
        Print.clearScreen();
        Print.title();
//        input.usernameInput();

        while (mainFlag.isGameRunning())
        {
            array.shuffle();
            if (mainFlag.isFirstTurn())
            {
                web.check(array.getWeb(), player.getCurrentPos(), log);
                player.potentialPos(array.getBuildings());
                charge.beforeTurnCheck(array, web.isStatus(), mainFlag, player.getCurrentPos(), log);
                charge.setHeight1(array.getBuildings().get(player.getCurrentPos()));
                ice.check(array.getFreeze(), player.getCurrentPos(), log);
                inputFlag.freezeOnExitCheck(array.getFreeze());
            }
            else
            {
                mainFlag.setFirstTurn(false);
            }
            do
            {
                if (mainFlag.isGameRunning())
                {
                    Print.inGameAll(ice.isStatus(), web.isStatus(), charge, inputFlag, array, player);
                    array.fuelCollect(player.getCurrentPos());
                    input.inputAction(ice.isStatus(), inputFlag);
                    input.action(mainFlag, inputFlag, ice, log, array, player);
                }
            }
            while (Validation.innerLoop(inputFlag));

            charge.setHeight2(array.getBuildings().get(player.getCurrentPos()));
            charge.afterChargeCheck(player, array, mainFlag, player.getCurrentPos(), log);
            mainFlag.wonGameCheck(player.getCurrentPos(), charge.getAmount());
        }
        Print.exit(charge.getAmount(), mainFlag, input.getName(), web.isStatus());
        FileIO.write(Values.WRITE_FILE, log.display(), input.getName());
    }
}
