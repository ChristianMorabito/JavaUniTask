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
        Position position = new Position(count, state);
        Fuel fuel = new Fuel(count);
        Parse parse = new Parse(fuel, count);
        Charge charge = new Charge(count, state);
        FileIO fileIO = new FileIO();
        fileIO.read();
        parse.define(fileIO.getData());
        parse.shuffleOnlyPortal();
        Print.clearScreen();
//        Print.title();
//        input.usernameInput();

        while (state.isGameRunning())
        {
            Web.turnOff(state);
            parse.shuffle();
            Web.check(state, parse.getWeb(), position.getCurrentPosition(), log);
            position.set(parse.buildings());
            charge.passiveCheck(position.getCurrentPosition(), fuel.getArray(), log);
            count.setHeight_1(parse.buildings().get(position.getCurrentPosition()));
            Frozen.check(state, parse.getFreeze(), position.getCurrentPosition(), log);
            state.exitCheck(position.getCurrentPosition());
            do
            {
                if (state.isGameRunning())
                {
                    Print.inGameAll(charge, state, count, fuel, parse, position);
                    fuel.collect(position.getCurrentPosition());
                    input.inputAction();
                    input.action(log, parse.buildings(), position);
                }
            }
            while (state.isOutOfRange() || state.isNumbersLoop());
            Frozen.turningOff(state);
            count.setHeight_2(parse.buildings().get(position.getCurrentPosition()));
            charge.activeCheck(position.getCurrentPosition(), fuel.getArray(), log);
        }
        Print.exit(charge.getAmount(), input.getName(), state.isExit(), state.isWebbed());
        fileIO.write(log.display(), input.getName());
    }
}