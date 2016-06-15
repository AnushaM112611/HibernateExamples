import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;


public class MYSQLConnection {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		//oracle.jdbc.driver.OracleDriver // "jdbc:oracle:thin:@localhost:3306:test","root","root"
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","root");
		String select = "SELECT * FROM student ";
	/*	String insertStatement = "insert into student values(?,?,?,?);";
		String updateStatement = "update student set name='Arjuna....' where id = 8";
		String deleteStatement = "delete from student where id = 8";
		
		Statement st = conn.createStatement();
		PreparedStatement ps = conn.prepareStatement(insertStatement);
		ps.setInt(1, 12);
		ps.setString(2, "Arjuna..");
		ps.setInt(3, 100);
		ps.setInt(4,19);
		ps.addBatch();
		
		ps.setInt(1, 11);
		ps.setString(2, "Sundar..");
		ps.setInt(3, 100);
		ps.setInt(4,29);
		ps.addBatch();
		
		ps.setInt(1, 13);
		ps.setString(2, "Rahul..");
		ps.setInt(3, 100);
		ps.setInt(4,39);
		ps.addBatch();
		
		ps.setInt(1, 14);
		ps.setString(2, "Sachin..");
		ps.setInt(3, 100);
		ps.setInt(4,49);
		ps.addBatch();
		
		ps.executeBatch();
		
		int rows = st.executeUpdate(deleteStatement);
		if(rows >= 1)
			System.out.println("Successfully Deleted");*/
		
	/*	ResultSet rs = st.executeQuery(select);
		while(rs.next()){
			System.out.println("ID :"+rs.getInt(1)+" Name:"+rs.getString(2)+" Marks:"+rs.getInt(3));
		}
		
		rs.close();*/
		
	    PreparedStatement ps = conn.prepareStatement("select * from student");
	    ResultSet rs = ps.executeQuery();
	    DatabaseMetaData dbMeta = conn.getMetaData();
	    System.out.println(dbMeta.getDriverName());
	    System.out.println(dbMeta.getDriverVersion());
	    System.out.println(dbMeta.getDatabaseProductName());
	    String tables[] = {"TABLE"};
	    ResultSet rs1 =dbMeta.getTables(null, null, null, tables);
	    while(rs1.next()){
	    	System.out.println(rs1.getString(3));
	    	  ResultSetMetaData metaInfo = rs1.getMetaData();
	  	    
	  	    System.out.println("         Total columns"+metaInfo.getColumnCount());
	  	    int n = metaInfo.getColumnCount();
	  	    for(int i=1;i<=n;i++){
	  	    	System.out.println("      Column Name: "+metaInfo.getColumnName(i)+" Column type:"+metaInfo.getColumnTypeName(i));
	  	    }
	    	
	    }
	    
	  
	    System.out.println("");
	    
	    
	    
		conn.close();
		
	}
}
