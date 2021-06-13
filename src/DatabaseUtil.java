import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class DatabaseUtil {
    static Connection connectionObj = null;
    public static Connection getConnection() throws Exception
    {
        if(connectionObj==null)
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connectionObj = DriverManager.getConnection("jdbc:mysql://localhost:3306/pwdkeeper", "root", "");
        }
        else if(!connectionObj.isClosed())
        {
            return connectionObj;
        }
        else
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connectionObj = DriverManager.getConnection("jdbc:mysql://localhost:3306/pdwkeeper", "root", "");
        }
        return connectionObj;
    }
}
