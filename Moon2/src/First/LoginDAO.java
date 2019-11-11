package First;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import First.FirstScreen;

public class LoginDAO {

	private Connection con;
	private Statement stmt;
	private ResultSet rs;
	/*String user = "moon"; 
    String pw = "3464";
    String url = "jdbc:oracle:thin:@localhost:1521:xe";*/
	private static final String DRIVER  = "oracle.jdbc.driver.OracleDriver";
		private static final String URL = "jdbc:oracle:thin:@10.50.208.41:1521:xe";
		private static final String USER = "mooncy"; 
		private static final String PW = "mooncy";
	   // private static final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
//	private static final String USER = "moon"; 
//	private static final String PW = "3464";

	public LoginDAO() {
		try {
			Class.forName(DRIVER);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}


	public int select2(String ID, String Pw) {

		String sql = "select M_PW from M_USER where M_ID="+ID;
		try {
			con = DriverManager.getConnection(URL, USER, PW);
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			if(rs.next()==false) {
				JOptionPane.showMessageDialog(null, "올바른 정보를 입력하세요", "경고 메시지", JOptionPane.WARNING_MESSAGE);
			}
			else {
					if(rs.getString("m_pw").equals(Pw)) {
						System.out.println("123");
						new FirstScreen(ID); 
						
						return 1;
					}
					else {
						JOptionPane.showMessageDialog(null, "올바른 정보를 입력하세요", "경고 메시지", JOptionPane.WARNING_MESSAGE);
					}
			}

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "ID를 입력하세요.", "경고 메시지", JOptionPane.WARNING_MESSAGE);
			e.printStackTrace();
		} finally {
			close(con, stmt, rs);
		}
		return 0;
	}

	public void close(Connection con, Statement stmt, ResultSet rs) {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
			}
		}
		if (stmt != null) {
			try {
				stmt.close();
			} catch (SQLException e) {
			}
		}
		if (con != null) {
			try {
				con.close();
			} catch (SQLException e) {
			}
		}
	}
}
