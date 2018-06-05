package db;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
public class DBTEST {
	public static void main(String[] args) {
		try {
		new DBTEST();
		}catch (SQLException e) {
			e.printStackTrace();
		}
}
	public DBTEST() throws SQLException {
		Connection conn = DriverManager.getConnection("jdbc:ucanaccess://C://Users//moritz-eliasschultze/DBTest.accdb;memory=false");
		
		Statement stmt = conn.createStatement();
		stmt.execute("INSERT INTO address (vorname,nachname,ort,plz)" + "VALUES ('mayonese','maier','wien',1190)");
	}
}
