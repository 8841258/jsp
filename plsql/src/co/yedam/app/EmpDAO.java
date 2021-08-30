package co.yedam.app;

import java.sql.CallableStatement;
import java.sql.SQLException;

public class EmpDAO extends DAO {
	
	public boolean delete(int empid) {
		
		connect();
		
		CallableStatement cstmt;
		
		String out_msg;
		
		try {
			cstmt = conn.prepareCall( "call del_emp(?, ?)");
			cstmt.setInt(1, empid);
			cstmt.registerOutParameter(2, java.sql.Types.VARCHAR);
			cstmt.executeUpdate();
			
			out_msg = cstmt.getString(2);
			
			return Boolean.getBoolean(out_msg);
		} catch (SQLException e) {
			return false;
		} finally {
			disconnect();
		}
		
		
	}
}
