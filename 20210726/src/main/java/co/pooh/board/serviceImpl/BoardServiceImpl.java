package co.pooh.board.serviceImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import co.pooh.board.dao.DAO;
import co.pooh.board.service.BoardService;
import co.pooh.board.vo.BoardVO;

public class BoardServiceImpl implements BoardService {

	private Connection conn;
	private PreparedStatement psmt;
	private ResultSet rs;
	private String sql;
	
	@Override
	public List<BoardVO> boardSelectList() {
		// 게시판 목록 가져오기
		List<BoardVO> list = new ArrayList<BoardVO>();
		sql = "select * from board order by bid desc";
		
		try {
			conn = DAO.getConnection();
			psmt = conn.prepareStatement(sql);
			
			rs = psmt.executeQuery();
			
			while (rs.next()) {
				BoardVO vo = new BoardVO();
				vo.setbId(rs.getInt("bid"));
				vo.setbTitle(rs.getString("btitle"));
//				vo.setbContent(rs.getString("bcontent"));
				vo.setbWriter(rs.getString("bwriter"));
				vo.setbDate(rs.getDate("bdate"));
				vo.setbHit(rs.getInt("bhit"));
				list.add(vo);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close();
		}
		return list;
	}

	private void close() {
		// TODO 연결을 종료시킨다.
		
		//연 순서(conn -> psmt -> rs)의 반대, 거꾸로.
			try {
				if (rs != null) rs.close();
				if (psmt != null) psmt.close();
				if (conn != null) conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		
		
		
	}

	@Override
	public BoardVO boardSelect(BoardVO vo) {
		// TODO 한행 가져오기. 게시글 조회.
		// 넘어온 vo 객체를 다시 돌려줌.
		sql = "select * from board where bid=?";
		try {
			conn = DAO.getConnection();
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, vo.getbId());
			rs = psmt.executeQuery();
			
			//결과가 한 행밖에 없다. rs가 있으면~ rs가 없으면~
			if (rs.next()) {
					vo.setbId(rs.getInt("bid"));
					vo.setbTitle(rs.getString("btitle"));
					vo.setbContent(rs.getString("bcontent"));
					vo.setbWriter(rs.getString("bwriter"));
					vo.setbDate(rs.getDate("bdate"));
					vo.setbHit(rs.getInt("bhit"));
					
					hitUpdate(vo.getbId());
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close();
		}
		return vo;
	}

	private void hitUpdate(int id) {
		// TODO 조회수 증가
		//finally, connection 필요 없다. 이미 위에서 한건조회할때 하기 때문!
		sql = "update board set bhit=bhit+1 where bid=?";
		
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
	public int boardInsert(BoardVO vo) {
		// TODO 글 추가
		
		String sql = "insert into board (bid, btitle, bcontent, bwriter, bdate) values(b_seq.nextval, ?, ?, ?, ?)";
		
		int n = 0;
		
		try {
			conn = DAO.getConnection();
			psmt = conn.prepareStatement(sql);
			
			psmt.setString(1, vo.getbTitle());
			psmt.setString(2, vo.getbContent());
			psmt.setString(3, vo.getbWriter());
			psmt.setDate(4, vo.getbDate());
			
			n = psmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		
		return n;
	}

	@Override
	public int boardDelete(BoardVO vo) {
		// TODO Auto-generated method stub
		String sql = "delete from board where bid=?";
		
		int n = 0;
		
		try {
			conn = DAO.getConnection();
			psmt = conn.prepareStatement(sql);
			
			psmt.setInt(1, vo.getbId());
			
			n = psmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close();
		}
		
		return n;
	}

	@Override
	public int boardUpdate(BoardVO vo) {
		// TODO 글제목, 글내용 변경
		
		String sql = "update board set btitle=?, bcontent=? where bid=?";
		
		int n = 0;
		
		try {
			conn = DAO.getConnection();
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getbTitle());
			psmt.setString(2, vo.getbContent());
			psmt.setInt(3, vo.getbId());
			n = psmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return n;
	}

}
