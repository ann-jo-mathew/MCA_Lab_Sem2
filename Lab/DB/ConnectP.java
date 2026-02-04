//prepared statements
import java.sql.*;
import java.util.*;
public class ConnectP{
	public static void main(String args[]){
		try{
			String no,na,sal,sql;
			Scanner s=new Scanner(System.in);
			Class.forName("oracle.jdbc.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:1521:oracl","mca","mca");
			System.out.println("Connected.."+con);
			Statement st=con.createStatement();
			PreparedStatement pst=con.prepareStatement("insert into empp values(?,?,?)");
			System.out.println("Enter the no,name and salary");
			no=s.nextLine();
			na=s.nextLine();
			sal=s.nextLine();
			pst.setInt(1,Integer.parseInt(no));
			pst.setString(2,na);
			pst.setFloat(3,Float.parseFloat(sal));
			pst.executeUpdate();
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
			
