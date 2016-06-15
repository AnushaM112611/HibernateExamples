import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.sql.Clob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StoreImages {

	public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException {
		Class.forName("com.mysql.jdbc.Driver");
		//oracle.jdbc.driver.OracleDriver // "jdbc:oracle:thin:@localhost:3306:test","root","root"
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/hibernatepractice","root","root");
		
		PreparedStatement ps = conn.prepareStatement("insert into image values(?,?,?)");
		ps.setInt(1, 2);
		
		FileInputStream fis = new FileInputStream("D:\\1.png");
		ps.setBinaryStream(2, fis,fis.available());
		
		File f = new File("D:\\app_log.log");
		FileReader fr = new FileReader(f);
		
		ps.setCharacterStream(3, fr, (int)f.length());
		ps.executeUpdate();
		System.out.println("Inserted");
		
		ps = conn.prepareStatement("select * from image");
		ResultSet rs = ps.executeQuery();
		if(rs.next()){
			java.sql.Blob b = rs.getBlob(2);
			byte image[] = b.getBytes(1, (int)b.length());
			FileOutputStream fos = new FileOutputStream("D:\\2.png");
			fos.write(image);
			fos.close();
			
			Clob c = rs.getClob(3);
			Reader r = c.getCharacterStream();
			FileWriter fw = new FileWriter("D:\\longtext.log");
			int i;
			while((i=r.read())!=-1){
				fw.write((char)i);
			}
			fw.close();
			
		}
		System.out.println("Created image");
	}
}
