package co.micol.member.serviceImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import co.micol.member.command.DAO;
import co.micol.member.service.MemberService;
import co.micol.member.vo.MemberVO;

public class MemberServiceImpl implements MemberService {
	
	private Connection conn;
	private PreparedStatement psmt;
	private ResultSet rs;
	
	@Override
	public List<MemberVO> memberSelectList() {
		// TODO 전체 회원 목록 보기
		List<MemberVO> members = new ArrayList<MemberVO>();
		MemberVO vo;
		
		String sql = "select * from member";
		
		try {
			conn = DAO.getConnection();
			psmt = conn.prepareStatement(sql);
			
			rs = psmt.executeQuery();
			
			while (rs.next()) {
				vo = new MemberVO();
				vo.setId(rs.getString("id"));
				vo.setPassword(rs.getString("password"));
				vo.setName(rs.getString("name"));
				vo.setAge(rs.getInt("age"));
				vo.setHobby(rs.getString("hobby"));
				members.add(vo);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return members;
	}

	
	private void close() {
		// TODO 커넥션 종료를 위해
			try {
				if (rs != null) {
				rs.close();
				}
				if (psmt != null) {
					psmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	}

	@Override
	public MemberVO memberSelect(MemberVO vo) {
		
		String sql = "select * from member where id=?";
		
		try {
			conn = DAO.getConnection();
			psmt = conn.prepareStatement(sql);
			
			psmt.setString(1, vo.getId());
			
			rs = psmt.executeQuery();
			
			if (rs.next()) {
				vo.setName(rs.getString("name"));
				vo.setPassword(rs.getString("password"));
				vo.setAge(rs.getInt("age"));
				vo.setHobby(rs.getString("hobby"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return vo;
	}

	@Override
	public int memberInsert(MemberVO vo) {
		// TODO 회원 추가하기
		int n=0;
		String sql = "insert into member values(?,?,?,?,?)";
		try {
			conn = DAO.getConnection();
			psmt = conn.prepareStatement(sql);
			
			psmt.setString(1, vo.getId());
			psmt.setString(2, vo.getPassword());
			psmt.setString(3, vo.getName());
			psmt.setInt(4, vo.getAge());
			psmt.setString(5, vo.getHobby());
			
			n = psmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return n;
	}

	@Override
	public int memberDelete(MemberVO vo) {
		// TODO 회원 삭제
		int n = 0;
		String sql = "delete from member where id=?";
		try {
			conn = DAO.getConnection();
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getId());
			n = psmt.executeUpdate();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} finally {
			close();
		}
		
		return n;
	}

	@Override
	public int memberUpdate(MemberVO vo) {
		// TODO 회원정보 변경
		int n=0;
		String sql = "update member set password=?, age=?, hobby=? where id=?";
		try {
			conn = DAO.getConnection();
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getPassword());
			psmt.setInt(2, vo.getAge());
			psmt.setString(3, vo.getHobby());
			psmt.setString(4, vo.getId());
			n = psmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close();
		}
		return n;
	}

}
