package models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import org.apache.derby.tools.sysinfo;

public class DBTest {

	public static void main(String[] args) {
		try {
			Class.forName("org.apache.derby.jdbc.ClientDriver");
			Connection conn = DriverManager.getConnection("jdbc:derby://localhost/library");
			Statement stm = conn.createStatement();
			ResultSet rs = stm.executeQuery("select * from materials");
		
			while(rs.next()) {
				System.out.println(rs.getString("title"));
			}
			rs.close();
			stm.close();
			conn.close();
			
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}

	}

}
