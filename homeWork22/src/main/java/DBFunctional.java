import java.sql.*;
import java.util.ArrayList;

public class DBFunctional {
    private static final String URL = "jdbc:mysql://localhost:3306/jdbc_project";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "Sekret";


    public void addUser(Person person) { //1
        Connection connection = getConnection();
        try {
            PreparedStatement statement =
                    connection.prepareStatement("INSERT INTO person(first_name, last_name, age) values(?, ?, ?)");
            statement.setString(1, person.getFirstName());
            statement.setString(2, person.getLastName());
            statement.setInt(3, person.getAge());

            statement.execute();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error!");
        }
    }

    public void getAllUsers() { //2
        Connection connection = getConnection();
        ArrayList<Person> usersList = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM person");
            ResultSet result = statement.executeQuery();

            while (result.next()) {
                usersList.add(new Person(result.getInt(1),
                        result.getString(2),
                        result.getString(3),
                        result.getInt(4)));
            }
            connection.close();
        } catch (SQLException e) {
            System.out.println("Error! Something went wrong");
        }

        usersList.forEach(System.out::println);
    }

    public void getAllUsersByAge(int age) { //3
        Connection connection = getConnection();
        ArrayList<Person> usersList = new ArrayList<>();

        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM person WHERE age > ?");
            statement.setInt(1, age);
            ResultSet result = statement.executeQuery();

            while (result.next()) {
                usersList.add(new Person(result.getInt(1),
                        result.getString(2),
                        result.getString(3),
                        result.getInt(4)));
            }
            connection.close();
        } catch (SQLException e) {
            System.out.println("Error!");
        }

        usersList.forEach(System.out::println);
    }

    public void deleteUser(int id) {  //4
        Connection connection = getConnection();
        try {
            PreparedStatement statement = connection.prepareStatement("DELETE FROM person WHERE id = ?");
            statement.setInt(1, id);
            statement.execute();
            connection.close();
            System.out.println("The operation was successful");
        } catch (SQLException e) {
            System.out.println("Error!");
        }
        System.out.println("The operation was successful");
    }

    public void updateDataUser(int id, int age) {  //5
        Connection connection = getConnection();
        try {
            PreparedStatement statement = connection.prepareStatement("UPDATE person SET age = age + ? WHERE id = ?");
            statement.setInt(1, age);
            statement.setInt(2, id);
            statement.execute();
            connection.close();
            System.out.println("The operation was successful");
        } catch (SQLException e) {
            System.out.println("Error!");
        }
    }

    public void getUserByID(int id) {  //6
        Connection connection = getConnection();
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM person WHERE id = ?");
            statement.setInt(1, id);
            ResultSet result = statement.executeQuery();

            while (result.next()) {
                System.out.println(new Person(result.getInt(1),
                        result.getString(2),
                        result.getString(3),
                        result.getInt(4)));
            }

            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error!");
        }
    }

    public void getUserByFirstName(String firstName) {  //7
        Connection connection = getConnection();
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM person WHERE first_name = ? LIMIT 1");
            statement.setString(1, firstName);
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                System.out.println(new Person(result.getInt(1),
                        result.getString(2),
                        result.getString(3),
                        result.getInt(4)));
            }

            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error!");
        }
    }

    private Connection getConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return connection;
    }
}
