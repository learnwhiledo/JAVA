package models;

import static org.hamcrest.CoreMatchers.instanceOf;

import java.security.GeneralSecurityException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.TreeMap;

import org.apache.derby.tools.sysinfo;

public class MaterialCatalogDatabaseVersion implements MaterialCatalogeInterface {

	public MaterialCatalogDatabaseVersion() {
		try {
			Class.forName("org.apache.derby.jdbc.ClientDriver");
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public void addMaterial(Material newMaterial) {
		Connection conn = null;
		PreparedStatement st = null;
		try {

			try {
				conn = DriverManager.getConnection("jdbc:derby://localhost/library");

				if (newMaterial instanceof Book) {
					Book newBook = (Book) newMaterial;
					String sql = "insert into materials (barcode,title,author,isbn,numberofpages,branch,type) values (?,?,?,?,?,?,'BOOK')";
					st = conn.prepareStatement(sql);
					st.setString(1, String.valueOf(newBook.getId()));
					st.setString(2, newBook.getTitle());
					st.setString(3, newBook.getAuthor());
					st.setString(4, newBook.getISBID());
					st.setInt(5, newBook.getNoofPages());
					st.setString(6, "Hyderabad");

				} else if (newMaterial instanceof DVD) {
					DVD newDVD = (DVD) newMaterial;
					String sql = "insert into materials (barcode,title,catalognumber,runningtime,licenced,branch,type) values (?,?,?,?,?,?,'DVD')";
					st = conn.prepareStatement(sql);
					st.setString(1, String.valueOf(newDVD.getId()));
					st.setString(2, newDVD.getTitle());
					st.setString(3, newDVD.getCatalog());
					st.setInt(4, newDVD.getRunnningTime());
					st.setBoolean(5, newDVD.getLicence());
					st.setString(6, newDVD.getBranch());
				}

				int result = st.executeUpdate();
				System.out.println("Records Added : " + result);
			} finally {
				if (st != null)
					st.close();
				if (conn != null)
					conn.close();
			}

		}

		catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public TreeMap<Integer, Material> getMaterialMap() {
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		try {

			try {
				conn = DriverManager.getConnection("jdbc:derby://localhost/library");
				st = conn.createStatement();
				rs = st.executeQuery("select * from materials");
				TreeMap<Integer, Material> allMaterial = new TreeMap<Integer, Material>();
				while (rs.next()) {
					String materialType = rs.getString("type");
					if (materialType.equalsIgnoreCase("BOOK")) {
						Book newBook = new Book(Integer.valueOf(rs.getString("barcode")), rs.getString("title"),
								rs.getString("author"), rs.getString("isbn"), rs.getString("branch"),
								rs.getInt("numberofpages"));
						allMaterial.put(Integer.valueOf(rs.getString("barcode")), newBook);

					} else if (materialType.equalsIgnoreCase("DVD")) {
						DVD newDVD = new DVD(Integer.valueOf(rs.getString("barcode")), rs.getString("title"),
								rs.getString("branch"), rs.getString("director"), rs.getString("catalognumber"),
								rs.getInt("runningtime"));

						allMaterial.put(Integer.valueOf(rs.getString("barcode")), newDVD);
					}
				}
				return allMaterial;

			} finally {

				if (rs != null)
					rs.close();
				if (st != null)
					st.close();
				if (conn != null)
					conn.close();
			}

		}

		catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public Material findMaterial(String title) throws MaterialNotfoundException {
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		try {

			try {
				conn = DriverManager.getConnection("jdbc:derby://localhost/library");
				st = conn.createStatement();
				rs = st.executeQuery("select * from materials where title like '%" + title + "%'");
				if (rs.next()) {
					String materialType = rs.getString("type");
					if (materialType.equalsIgnoreCase("BOOK")) {
						Book newBook = new Book(Integer.valueOf(rs.getString("barcode")), rs.getString("title"),
								rs.getString("author"), rs.getString("isbn"), rs.getString("branch"),
								rs.getInt("numberofpages"));
						return newBook;
					} else if (materialType.equalsIgnoreCase("DVD")) {
						DVD newDVD = new DVD(Integer.valueOf(rs.getString("barcode")), rs.getString("title"),
								rs.getString("branch"), rs.getString("director"), rs.getString("catalognumber"),
								rs.getInt("runningtime"));
						return newDVD;
					} else {
						throw new MaterialNotfoundException();
					}
				} else {
					throw new MaterialNotfoundException();
				}

			} finally {

				if (rs != null)
					rs.close();
				if (st != null)
					st.close();
				if (conn != null)
					conn.close();
			}

		}

		catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public int getNumberOfMaterials() {
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		try {

			try {
				conn = DriverManager.getConnection("jdbc:derby://localhost/library");
				st = conn.createStatement();
				rs = st.executeQuery("select count(id) from materials");
				rs.next();
				return rs.getInt(1);

			} finally {

				if (rs != null)
					rs.close();
				if (st != null)
					st.close();
				if (conn != null)
					conn.close();
			}

		}

		 catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

}
