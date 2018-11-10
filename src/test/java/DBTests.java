import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class DBTests {

    @Test
    public void connect() {
        String sql = "SELECT title FROM sakila.film where rental_duration > ? and rental_rate >= ?";
        String sqlUpd = "INSERT INTO `sakila`.`film` (`title`, `release_year`, `language_id`) " +
                "VALUES (?, ?, ?)";

        Properties props = getConnectionData();

        String url = props.getProperty("db.url");
        String user = props.getProperty("db.user");
        String passwd = props.getProperty("db.passwd");

        try(Connection con = DriverManager.getConnection(url, user, passwd);
            PreparedStatement pst1 = con.prepareStatement(sql);
            PreparedStatement pst2 = con.prepareStatement(sqlUpd)
        ) {
            pst1.setInt(1,3);
            pst1.setDouble(2,4.1);

            pst2.setString(1,"Film Name");
            pst2.setInt(2,2018);
            pst2.setInt(3,1);

            //Statement st = con.createStatement();
            /*if (pst1.execute()) {
                ResultSet rs = pst1.getResultSet();//executeQuery(sql);

                while (rs.next()) {
                    //int id = rs.getInt(1);
                    //String first = rs.getString(2);
                    //String last = rs.getString("last_name");
                    //Timestamp ts = rs.getTimestamp("last_update");
                    System.out.println(rs.getString(1));
                }
            }*/

            pst2.execute();
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        }

    private static Properties getConnectionData() {

        Properties props = new Properties();

        String fileName = "src/main/resources/db.properties";

        try (FileInputStream in = new FileInputStream(fileName)) {
            props.load(in);
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        return props;
    }
}
