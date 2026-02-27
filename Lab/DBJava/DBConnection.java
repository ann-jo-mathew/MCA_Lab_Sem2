import java.sql.*;
 
public class DBConnection 
{
    public static void main(String[] args) {
        try {
            Class.forName("oracle.jdbc.OracleDriver");
          Connection con = DriverManager.getConnection(
            "jdbc:oracle:thin:@//localhost:1521/XE",
            "ann",
            "1234"
            );
            System.out.println("connected.."+con);
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from test1");
            while(rs.next())
            {
                System.out.println( rs.getString(1)+rs.getString(2));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } 
    }
 
}