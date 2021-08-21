import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBConnection {

  private static Connection connection;

  private static String dbName = "learn";
  private static String dbUser = "root";
  private static String dbPass = "ecyhbdcbhg346((87fM";
  private static StringBuilder insertQuery = new StringBuilder();

  public static Connection getConnection() {
    if (connection == null) {
      try {
        connection = DriverManager.getConnection(
            "jdbc:mysql://localhost:3306/" + dbName + "?useSSL=false&serverTimezone=UTC", dbUser,
            dbPass);
        connection.createStatement().execute("DROP TABLE IF EXISTS voter");
        connection.createStatement().execute("CREATE TABLE voter(" +
            "id INT NOT NULL AUTO_INCREMENT, " +
            "name TINYTEXT NOT NULL, " +
            "birthDate DATE NOT NULL, " +
            "PRIMARY KEY(id))");
      } catch (SQLException e) {
        e.printStackTrace();
      }
    }
    return connection;
  }

  public static void executeMultiInsert() throws SQLException {
    if (insertQuery.length() > 0) {
      String sql = "INSERT INTO voter(name,birthDate) VALUES" + insertQuery;
      DBConnection.getConnection().createStatement().execute(sql);
    }
  }

  public static void countVoter(String name, String birthDay) throws SQLException {
    insertQuery.append((insertQuery.length() == 0 ? "" : ",") +
        "('" + name + "', '" + birthDay + "')");

    if (insertQuery.length() > 2_900_000) {
      executeMultiInsert();
      insertQuery.delete(0, insertQuery.length());
    }
  }

  public static void printVoterCounts() throws SQLException {
    String sql = "SELECT name,birthDate, COUNT(*) as visits FROM learn.voter GROUP BY name, birthDate HAVING COUNT(*) > 1";
    ResultSet rs = DBConnection.getConnection().createStatement().executeQuery(sql);
    while (rs.next()) {
      System.out.println("\t" + rs.getString("name") + " (" +
          rs.getString("birthDate") + ") - " + rs.getInt("visits"));
    }
  }
}
