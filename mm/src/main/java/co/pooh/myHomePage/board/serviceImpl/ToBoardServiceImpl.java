package co.pooh.myHomePage.board.serviceImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import co.pooh.myHomePage.board.service.ToBoardService;
import co.pooh.myHomePage.board.vo.FromBoardVO;
import co.pooh.myHomePage.board.vo.ToBoardVO;
import co.pooh.myHomePage.common.DAO;

public class ToBoardServiceImpl implements ToBoardService {
	
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
	public List<ToBoardVO> toBoardSelectList() {
		List<ToBoardVO> list = new ArrayList<ToBoardVO>();
		ToBoardVO vo;
		sql = "select * from toboard order by todate desc";
		try {
			conn = DAO.getConnection();
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while (rs.next()) {
				vo = new ToBoardVO();
				vo.setToNo(rs.getInt("tono"));
				vo.setToDate(rs.getDate("todate"));
				vo.setToWriter(rs.getString("towriter"));
				vo.setToContent(rs.getString("tocontent"));
				vo.setToLike(rs.getInt("tolike"));
				list.add(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return list;
	}

	@Override
	public int toBoardInsert(ToBoardVO vo) {
		int r = 0;
		sql = "insert into toboard (tono, towriter, tocontent) values (to_seq.nextval, ?, ?)";
		try {
			conn = DAO.getConnection();
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getToWriter());
			psmt.setString(2, vo.getToContent());
			r = psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return r;
	}

	@Override
	public int toBoardDelete(ToBoardVO vo) {
		int r = 0;
		sql = "delete from toboard where tono=? and towriter=?";
		try {
			conn = DAO.getConnection();
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, vo.getToNo());
			psmt.setString(2, vo.getToWriter());
			r = psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return r;
	}

}
