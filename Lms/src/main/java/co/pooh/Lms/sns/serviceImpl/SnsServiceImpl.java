package co.pooh.Lms.sns.serviceImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import co.pooh.Lms.common.DAO;
import co.pooh.Lms.sns.service.SnsService;
import co.pooh.Lms.sns.vo.CommentsVO;
import co.pooh.Lms.sns.vo.SnsVO;

public class SnsServiceImpl implements SnsService {

	private Connection conn;
	private PreparedStatement psmt;
	private ResultSet rs;
	private String sql;

	@Override
	public List<SnsVO> snsSelectList() {
		// TODO sns 글 목록 가져오기
		List<SnsVO> list = new ArrayList<SnsVO>();
		sql = "select * from sns";
		SnsVO vo;
		try {
			conn = DAO.getConnection();
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();

			while (rs.next()) {
				vo = new SnsVO();
				vo.setsNo(rs.getInt("sno"));
				vo.setsWriter(rs.getString("swriter"));
				vo.setsDate(rs.getDate("sdate"));
				vo.setsTitle(rs.getString("stitle"));
				vo.setsAno(rs.getInt("sano"));
				list.add(vo);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return list;
	}

	private void close() {
		// TODO Auto-generated method stub
		try {
			if (rs != null)
				rs.close();
			if (psmt != null)
				psmt.close();
			if (conn != null)
				conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public List<SnsVO> snsSelect(int no) {
		// TODO 선택한 글을 댓글을 포함해서 가져옴
		List<SnsVO> list = new ArrayList<SnsVO>();
		SnsVO vo;
		sql = "select a.*, b.cname, b.csubject, b.cdate from sns a left outer join comments b on (a.sno = b.sno) where a.sno=?";

		try {
			conn = DAO.getConnection();
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, no);

			rs = psmt.executeQuery();

			while (rs.next()) {
				vo = new SnsVO();
				vo.setsNo(rs.getInt("sno"));
				vo.setsWriter(rs.getString("swriter"));
				vo.setsDate(rs.getDate("sdate"));
				vo.setsTitle(rs.getString("stitle"));
				vo.setsContents(rs.getString("scontents"));
				vo.setsAno(rs.getInt("sano"));
				vo.setcName(rs.getString("cname"));
				vo.setcSubject(rs.getString("csubject"));
				vo.setcDate(rs.getDate("cdate"));
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

	@Override
	public int snsInsert(SnsVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int commentsInsert(CommentsVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int snsUpdate(SnsVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int commentsUpdate(CommentsVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int snsDelete(SnsVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int commentsDelete(CommentsVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

}
