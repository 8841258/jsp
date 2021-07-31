package co.pooh.myHomePage.board.serviceImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import co.pooh.myHomePage.board.service.FMemberService;
import co.pooh.myHomePage.common.DAO;
import co.pooh.myHomePage.fmember.vo.FMemberVO;

public class FMemberServiceImpl implements FMemberService {
	private Connection conn;
	   private PreparedStatement psmt;
	   private ResultSet rs;
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
	   public FMemberVO login(FMemberVO vo) {
	      sql = "select nickname, author from fmember where id=? and password=? and state='Y'";
	      try {
	         conn = DAO.getConnection();
	         psmt = conn.prepareStatement(sql);
	         psmt.setString(1, vo.getId());
	         psmt.setString(2, vo.getPassword());
	         rs = psmt.executeQuery();
	         if(rs.next()) {
	            vo.setNickname(rs.getString("nickname"));
	            vo.setAuthor(rs.getString("author"));
	         }
	      } catch (SQLException e) {
	         e.printStackTrace();
	      } finally {
	         close();
	      }
	      return vo;
	   }

	   @Override
	   public int memberInsert(FMemberVO vo) {
	      int r = 0;
	      sql = "insert into fmember (id,password,nickname,name,email) values(?,?,?,?,?)";
	      try {
	         conn = DAO.getConnection();
	         psmt = conn.prepareStatement(sql);
	         psmt.setString(1, vo.getId());
	         psmt.setString(2, vo.getPassword());
	         psmt.setString(3, vo.getNickname());
	         psmt.setString(4, vo.getName());
	         psmt.setString(5, vo.getEmail());
	         r = psmt.executeUpdate();
	      } catch (SQLException e) {
	         e.printStackTrace();
	      } finally {
	         close();
	      }
	      return r;
	   }

	   @Override
	   public int memberDelete(FMemberVO vo) {
	      int r = 0;
	      String sql = "delete from fmember where id=?";
	      try {
	         conn = DAO.getConnection();
	         psmt = conn.prepareStatement(sql);
	         psmt.setString(1, vo.getId());
	         r = psmt.executeUpdate();
	      } catch (SQLException e) {
	         e.printStackTrace();
	      } finally {
	         close();
	      }
	      return r;
	   }
	}
