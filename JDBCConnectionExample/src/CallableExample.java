import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class CallableExample {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		//oracle.jdbc.driver.OracleDriver // "jdbc:oracle:thin:@localhost:3306:test","root","root"
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/hibernatepractice","root","root");
		
		conn.setAutoCommit(false);
		CallableStatement cs = conn.prepareCall("{call sample(?,?)}");
		cs.setInt(1, 13);
		cs.setString(2, "aaaaaaa");
		cs.execute();
		int i = 2;
		if(i == 1)
			throw new SQLException();
		java.sql.PreparedStatement ps = conn.prepareStatement("insert into car values(10,'name','manu')");
		ps.executeUpdate();
		
		conn.commit();
		System.out.println("Success");
		
	}
}
