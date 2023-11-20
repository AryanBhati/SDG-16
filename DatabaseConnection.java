import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseConnection {
    private static final String INSERT_USER_SQL = "INSERT INTO users (username, password, email) VALUES (?, ?, ?)";
    private static final Statement DatabaseConnection = null;

    public boolean signUp(String username, String password, String email) {
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USER_SQL)) {
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            preparedStatement.setString(3, email);

            int rowsAffected = preparedStatement.executeUpdate();

            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static void main(String[] args) {
        DatabaseConnection signUpPage = new DatabaseConnection();

        // Example usage: signing up a user
        String username = "example_user";
        String password = "example_password";
        String email = "example@example.com";

        if (signUpPage.signUp(username, password, email)) {
            System.out.println("User signed up successfully.");
        } else {
            System.out.println("Failed to sign up.");
        }
    }

    public static Connection getConnection() {
        return null;
    }
}
