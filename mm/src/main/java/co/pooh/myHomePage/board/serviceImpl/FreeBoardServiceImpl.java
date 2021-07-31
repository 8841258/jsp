package co.pooh.myHomePage.board.serviceImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import co.pooh.myHomePage.board.service.FreeBoardService;
import co.pooh.myHomePage.board.vo.FreeBoardVO;
import co.pooh.myHomePage.common.DAO;

public class FreeBoardServiceImpl implements FreeBoardService {

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
	public List<FreeBoardVO> freeBoardSelectList() {
		List<FreeBoardVO> list = new ArrayList<FreeBoardVO>();
		FreeBoardVO vo;
		sql = "select * from freeboard";
		try {
			conn = DAO.getConnection();
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while (rs.next()) {
				vo = new FreeBoardVO();
				vo.setFreeNo(rs.getInt("freeno"));
				vo.setFreeTitle(rs.getString("freetitle"));
				vo.setFreeDate(rs.getDate("freedate"));
				vo.setFreeWriter(rs.getString("freewriter"));
				vo.setFreeCnum(rs.getString("freecnum"));
				vo.setHit(rs.getInt("freehit"));
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
	public FreeBoardVO freeBoardSelect(FreeBoardVO vo) {
		sql = "select * from freeboard where freeno = ?";
		try {
			conn = DAO.getConnection();
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, vo.getFreeNo());
			rs = psmt.executeQuery();
			if (rs.next()) {
				vo.setFreeNo(rs.getInt("freeno"));
				vo.setFreeTitle(rs.getString("freetitle"));
				vo.setFreeDate(rs.getDate("freedate"));
				vo.setFreeWriter(rs.getString("freewriter"));
				vo.setFreeContent(rs.getString("freecontent"));
				vo.setFreeCnum(rs.getString("freecnum"));
				vo.setHit(rs.getInt("freehit"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return vo;
	}

	@Override
	public int freeBoardInsert(FreeBoardVO vo) {
		int r = 0;
		sql = "insert into freeboard (freeno, freetitle, freewriter, freecontent) values (freeb_seq.nextval, ?, ?, ?)";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getFreeTitle());
			psmt.setString(2, vo.getFreeWriter());
			psmt.setString(3, vo.getFreeContent());
			r = psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return r;
	}

	@Override
	public int freeBoardUpdate(FreeBoardVO vo) {
		int r = 0;
		sql = "update freeboard set freetitle = ?, freecontent = ? where freeno = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getFreeTitle());
			psmt.setString(2, vo.getFreeContent());
			psmt.setInt(3, vo.getFreeNo());
			r = psmt.executeUpdate();
			r = psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return r;
	}

	@Override
	public int freeBoardDelete(FreeBoardVO vo) {
		int r = 0;
		sql = "delete from freeboard where freeno = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, vo.getFreeNo());
			r = psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return r;
	}

}
