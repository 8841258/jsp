package co.pooh.myHomePage.board.serviceImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import co.pooh.myHomePage.board.service.FromBoardService;
import co.pooh.myHomePage.board.vo.FreeBoardVO;
import co.pooh.myHomePage.board.vo.FromBoardVO;
import co.pooh.myHomePage.common.DAO;

public class FromBoardServiceImpl implements FromBoardService {
	
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
	public List<FromBoardVO> fromBoardSelectList() {
		List<FromBoardVO> list = new ArrayList<FromBoardVO>();
		FromBoardVO vo;
		sql = "select * from fromboard order by fromdate desc";
		try {
			conn = DAO.getConnection();
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while (rs.next()) {
				vo = new FromBoardVO();
				vo.setFromDate(rs.getDate("fromdate"));
				vo.setFromWriter(rs.getString("fromwriter"));
				vo.setFromContent(rs.getString("fromcontent"));
				vo.setFromLike(rs.getInt("fromlike"));
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
	public int fromBoardInsert(FromBoardVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int fromBoardDelete(FromBoardVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

}
