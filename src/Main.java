public class Main {

    public static void main(String[] args) {
        ParsedData parsedData = new ParsedData();
        UserInput userInput = new UserInput();
        CharacterPosition characterPosition = new CharacterPosition();
        Fuel fuel = new Fuel();
        parsedData.define();
        boolean gameLoop = true;
        int exit = 100; // TODO: Make magic numbers in a shared class
        while (gameLoop){
            parsedData.shuffleData();
            int result = -1;
            while (result < 0){
                new Graphics().createGraphic(parsedData, result);
                userInput.optionInput();
                result = characterPosition.move(parsedData, userInput.getAction());
            }
            if (result == exit) {
                gameLoop = false;
            }
        }
        System.out.println("Exiting...");
        //TODO: ORGANISE WRITE RESULTS

    }
}