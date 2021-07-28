package co.pooh.Lms.board.ServiceImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import co.pooh.Lms.board.Service.BoardService;
import co.pooh.Lms.board.vo.BoardVO;
import co.pooh.Lms.common.DAO;

public class BoardServiceImpl implements BoardService {
	private Connection conn;
	private PreparedStatement psmt;
	private ResultSet rs;
	private String sql;

	@Override
	public List<BoardVO> boardSelectList() {
		// TODO 게시판 목록 가져오기
		List<BoardVO> list = new ArrayList<BoardVO>();
		BoardVO vo;
		sql = "select * from board";
		try {
			conn = DAO.getConnection();
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			
			while (rs.next()) {
				vo = new BoardVO();
				vo.setbId(rs.getInt("bid"));
				vo.setbWriter(rs.getString("bwriter"));
				vo.setbTitle(rs.getString("btitle"));
				vo.setbDate(rs.getDate("bdate"));
				vo.setbHit(rs.getInt("bhit"));
				list.add(vo);
			}
			
		} catch (SQLException e) {
			
		} finally {
			close();
		}
		
		return list;
	}

	private void close() {
		// TODO Auto-generated method stub

			try {
				if (rs != null) rs.close();
				if (psmt != null) rs.close();
				if (conn != null) rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

	}

	@Override
	public BoardVO boardSelect(BoardVO vo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int boardInsert(BoardVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int boardUpdate(BoardVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int boardDelete(BoardVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

}
