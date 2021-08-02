package co.pooh.myHomePage.board.serviceImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import co.pooh.myHomePage.board.service.FreeCommentService;
import co.pooh.myHomePage.board.vo.FreeCommentVO;
import co.pooh.myHomePage.common.DAO;

public class FreeCommentServiceImpl implements FreeCommentService {

	Connection conn;
	PreparedStatement psmt;
	ResultSet rs;
	String sql;

	private void close() {
		try {
			if (rs != null)
				rs.close();
			if (psmt != null)
				psmt.close();
			if (conn != null)
				conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public int freeBoardInsert(FreeCommentVO vo) {
		int r = 0;
		sql = "insert into freecomment (freeno, freecno, freeccontent, freecwriter) values(?, freec_seq.nextval, ?, ?)";
		try {
			conn = DAO.getConnection();
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, vo.getFreeNO());
			psmt.setString(2, vo.getFreeCcontent());
			psmt.setString(3, vo.getFreeCwriter());
			r = psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return r;
	}

	@Override
	public int freeBoardDelete(FreeCommentVO vo) {
		int r = 0;
		sql = "delete from freecomment where freecno=?";
		try {
			conn = DAO.getConnection();
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, vo.getFreeCno());
			r = psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return r;
	}

}
