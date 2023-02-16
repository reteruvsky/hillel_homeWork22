import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class App {

    public static void main(String[] args) throws IOException {
        DBFunctional functional = new DBFunctional();

        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Welcome to my Application!");
        System.out.println("Press \"1\" for add some User");
        System.out.println("Press \"2\" for get all Users");
        System.out.println("Press \"3\" for get all Users older than specified age");
        System.out.println("Press \"4\" for delete User by ID");
        System.out.println("Press \"5\" for update information about User");
        System.out.println("Press \"6\" for get User by ID");
        System.out.println("Press \"7\" for get User by first name");
        System.out.println("Press \"8\" for quit!");

        boolean bool = true;

        while (bool) {
            int index = 0;
            String str = buf.readLine();

            try {
                index = Integer.parseInt(str);
            } catch (Exception e) {
                System.out.println("Incorrect input data!");
                break;
            }

            switch (index) {
                case 1 -> {
                    System.out.println("Enter your User's data");
                    functional.addUser(new Person(Integer.parseInt(buf.readLine()),
                            buf.readLine(),
                            buf.readLine(),
                            Integer.parseInt(buf.readLine())));
                }
                case 2 -> {
                    System.out.println("Let's get your Users.");
                    functional.getAllUsers();
                }
                case 3 -> {
                    System.out.println("Write the age please.");
                    functional.getAllUsersByAge(Integer.parseInt(buf.readLine()));
                }
                case 4 -> {
                    System.out.println("Write ID of User please.");
                    functional.deleteUser(Integer.parseInt(buf.readLine()));
                }
                case 5 -> {
                    System.out.println("Write the ID and age of User please");
                    functional.updateDataUser(Integer.parseInt(buf.readLine()),
                            Integer.parseInt(buf.readLine()));
                }
                case 6 -> {
                    System.out.println("Write the ID of User please.");
                    functional.getUserByID(Integer.parseInt(buf.readLine()));
                }
                case 7 -> {
                    System.out.println("Write the first name of User please.");
                    functional.getUserByFirstName(buf.readLine());
                }
                case 8 -> bool = false;
                default -> System.out.println("You entered the wrong number!");
            }
        }
    }
}
