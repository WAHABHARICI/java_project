package application;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author MarcoMan Subscribe our Channel -->
 *         https://www.youtube.com/channel/UCPgcmw0LXToDn49akUEJBkQ Thanks for
 *         the support guys! <3
 */
public class database {

	public static Connection connectDb() {

		try {

			Class.forName("com.mysql.cj.jdbc.Driver");

			Connection connect = DriverManager.getConnection("jdbc:mysql://localhost/employee", "root", "Djamel14");
			return connect;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
