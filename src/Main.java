public class Main {

    public static void main(String[] args) {
        Organise organise = new Organise();
        UserInput userInput = new UserInput();
        Conditions conditions = new Conditions();
        organise.define();
        organise.shuffleData();
        new Graphics().buildingPrint(organise, conditions.getCurrentPosition());

        int i = 0;
        while (i < 3){
            int result = conditions.move(organise, userInput.getAction());
            new Graphics().buildingPrint(organise, result);
            i++;
        }

    }
}