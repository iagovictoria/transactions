package transaction;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import javax.sql.DataSource;
/**
 *
 * @author 11204974
 */
public class BancoDadosDataSource {
    public static String DB_CONN_STRING = "jdbc:derby://localhost:1527/tecnicas";
    public static String DB_NAME = "ROOT";
    public static String USER_NAME = "root";
    public static String PASSWORD = "root";
    private static DataSource dataSource;
    
    public static Connection conectarBd() throws Exception {
        return DriverManager.getConnection(DB_CONN_STRING, USER_NAME, PASSWORD);
    }
}