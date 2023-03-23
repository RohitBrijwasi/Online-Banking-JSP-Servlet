package my;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class verifyLogin1 {

	public static boolean checkLogin(int accountno, String username, String password) {
		boolean status = false;
		Connection con = GetCon.getCon();
		try {
			PreparedStatement pmt = con.prepareStatement("select * from newaccount where accountno = ? and username = ? and password = ?");
			pmt.setInt(1, accountno);
			pmt.setString(2, username);
			pmt.setString(3, password);

			ResultSet rs = pmt.executeQuery();
			status = rs.next();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return status;
	}

}
