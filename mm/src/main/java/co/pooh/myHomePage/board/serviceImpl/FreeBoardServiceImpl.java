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
		sql = "select * from freeboard order by freeno desc";
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
				vo.setHit(rs.getInt("hit"));
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
	public List<FreeBoardVO> freeBoardSelect(int no) {
		List<FreeBoardVO> list = new ArrayList<FreeBoardVO>();
		FreeBoardVO vo;
		sql = "select a.*, b.freecwriter, b.freeccontent, b.freecdate, b.freecno\r\n"
				+ "from freeboard a left outer join freecomment b\r\n" + "on (a.freeno = b.freeno)\r\n"
				+ "where a.freeno=?";
		try {
			conn = DAO.getConnection();
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, no);
			rs = psmt.executeQuery();
			while (rs.next()) {
				vo = new FreeBoardVO();
				vo.setFreeNo(rs.getInt("freeno"));
				vo.setFreeTitle(rs.getString("freetitle"));
				vo.setFreeDate(rs.getDate("freedate"));
				vo.setFreeWriter(rs.getString("freewriter"));
				vo.setFreeContent(rs.getString("freecontent"));
				vo.setFreeCnum(rs.getString("freecnum"));
				vo.setHit(rs.getInt("hit"));
				vo.setFreeCwriter(rs.getString("freecwriter"));
				vo.setFreeCcontent(rs.getString("freeccontent"));
				vo.setFreeCdate(rs.getDate("freecdate"));
				vo.setFreeCno(rs.getInt("freecno"));
				hitUpdate(vo.getFreeNo());
				list.add(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return list;
	}

	private void hitUpdate(int id) {
		// TODO 조회수 증가
		// finally, connection 필요 없다. 이미 위에서 한건조회할때 하기 때문!
		sql = "update freeboard set hit=hit+1 where freeno=?";

		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, id);
			psmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public int freeBoardInsert(FreeBoardVO vo) {
		int r = 0;
		sql = "insert into freeboard (freeno, freetitle, freewriter, freecontent) values (freeb_seq.nextval, ?, ?, ?)";
		try {
			conn = DAO.getConnection();
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
			conn = DAO.getConnection();
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getFreeTitle());
			psmt.setString(2, vo.getFreeContent());
			psmt.setInt(3, vo.getFreeNo());
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
			conn = DAO.getConnection();
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

	// 수정에서 불러오는 용도의 한건조회
	@Override
	public FreeBoardVO freeBoardSelect2(int r) {
		FreeBoardVO vo = null;
		sql = "select freeno, freetitle, freecontent from freeboard where freeno=?";
		try {
			conn = DAO.getConnection();
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, r);
			rs = psmt.executeQuery();

			// 결과가 한 행밖에 없다. rs가 있으면~ rs가 없으면~
			if (rs.next()) {
				vo = new FreeBoardVO();
				vo.setFreeNo(rs.getInt("freeno"));
				vo.setFreeTitle(rs.getString("freetitle"));
				vo.setFreeContent(rs.getString("freecontent"));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close();
		}
		return vo;
	}

}
