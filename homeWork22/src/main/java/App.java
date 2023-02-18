import java.io.IOException;
import java.util.Scanner;

public class App {

    public static void main(String[] args) throws IOException {
        DBFunctional functional = new DBFunctional();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to my Application!");
        System.out.println("Press \"1\" for add some User");
        System.out.println("Press \"2\" for get all Users");
        System.out.println("Press \"3\" for get all Users older than specified age");
        System.out.println("Press \"4\" for delete User by ID");
        System.out.println("Press \"5\" for update information about User");
        System.out.println("Press \"6\" for get User by ID");
        System.out.println("Press \"7\" for get User by first name");
        System.out.println("Press \"8\" for quit!");


        while (true) {
            int index = 0;

            try {
                index = scanner.nextInt();
            } catch (Exception e) {
                System.out.println("Incorrect input data!");
                break;
            }

            switch (index) {
                case 1 -> {
                    System.out.println("Enter your User's data");
                    functional.addUser(new Person(scanner.nextInt(),
                            scanner.nextLine(),
                            scanner.nextLine(),
                            scanner.nextInt()));
                }
                case 2 -> {
                    System.out.println("Let's get your Users.");
                    functional.getAllUsers();
                }
                case 3 -> {
                    System.out.println("Write the age please.");
                    functional.getAllUsersByAge(scanner.nextInt());
                }
                case 4 -> {
                    System.out.println("Write ID of User please.");
                    functional.deleteUser(scanner.nextInt());
                }
                case 5 -> {
                    System.out.println("Write the ID and age of User please");
                    functional.updateDataUser(scanner.nextInt(),
                            scanner.nextInt());
                }
                case 6 -> {
                    System.out.println("Write the ID of User please.");
                    functional.getUserByID(scanner.nextInt());
                }
                case 7 -> {
                    System.out.println("Write the first name of User please.");
                    functional.getUserByFirstName(scanner.nextLine());
                }
                case 8 -> {
                    return;
                }
                default -> System.out.println("You entered the wrong number!");
            }
        }
    }
}
