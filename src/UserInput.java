import java.util.Scanner;

public class UserInput {

    private String userName;

    private int action;

    UserInput(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your username. Must be between 3 to 12 characters long.");
        while (true){
            System.out.print("Username: ");
            userName = scanner.nextLine();
            if (userName.length() > 2 && userName.length() < 13 && userName.matches("[a-zA-Z]+")){
                break;
            }
            else{
                System.out.println("Invalid input! Please try again.");
            }

        }
    }

    public void optionInput() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("""
                Enter a number between 1 & 4.
                1) Jump RIGHT
                2) Jump LEFT
                3) Skip Turn
                4) Exit
                """);

        while (true){
            try {
                action = scanner.nextInt();
                if (action > 0 && action < 5){
                    break;
                }
                System.out.println("Invalid Input! Please try again.");

            } catch (Exception e){
                scanner.next();
            }
        }
    }

    public String getUserName() {
        return userName;
    }

    public int getAction() {
        return action;
    }
}
