package view.common;

/*
public class LoginDAO {
    public LoginDAO() {
        super();
    }
}
*/

import com.asn1c.core.Null;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

//import com.journaldev.jsf.util.DataConnect;

public class LoginDAO {
    

	public static String validate(String user, String password) {
		Connection con = null;
		PreparedStatement ps = null;


		try {
			con = DataConnect.getConnection();
			//ps = con.prepareStatement("Select EMAIL_ID, PASSWORD from AKMR_USERS_MASTER where EMAIL_ID = ? and PASSWORD = ?");
                        ps = con.prepareStatement("Select EMAIL_ID, PASSWORD, IS_ENABLED, USER_TYPE from AKMR_USERS_MASTER where EMAIL_ID = ? and PASSWORD = ? and IS_ENABLED = 1");
			ps.setString(1, user);
			ps.setString(2, password);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				//result found, means valid inputs
                                return rs.getString("USER_TYPE");
				//return true;
			}
		} catch (SQLException ex) {
			System.out.println("Login error -->" + ex.getMessage());
			return null;
		} finally {
			DataConnect.close(con);
		}
		return null;
	}
}
