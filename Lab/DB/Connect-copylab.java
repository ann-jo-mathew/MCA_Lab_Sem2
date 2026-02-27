import java.sql.*;
import java.util.*;
public class Connect{
	public static void main(String args[]){
		try{
			String no,na,sal,sql;
			Scanner s=new Scanner(System.in);
			Class.forName("oracle.jdbc.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:1521:oracl","mca","mca");
			System.out.println("Connected.."+con);
			Statement st=con.createStatement();
			System.out.println("Enter the no,name and salary");
			no=s.nextLine();
			na=s.nextLine();
			sal=s.nextLine();
			sql="insert into empp values("+no+",'"+na+"',"+sal+")";
			st.executeUpdate(sql);
			ResultSet rs = st.executeQuery("select * from empp");
			while(rs.next())
			{
				System.out.println(rs.getString(1) + "  " + rs.getString(2)+" "+rs.getString(3));
			}
        	} catch (ClassNotFoundException e) {
            	// TODO Auto-generated catch block
           	e.printStackTrace();
        	} catch (SQLException e) {
            	// TODO Auto-generated catch block
            e.printStackTrace();
        }
         
    }
 
}
			
