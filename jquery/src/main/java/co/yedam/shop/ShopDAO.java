package co.yedam.shop;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ShopDAO extends DAO {
	PreparedStatement psmt;
	ResultSet rs;
	
	public List<ShopVO> getItemList() {
		List<ShopVO> list = new ArrayList<ShopVO>();
		ShopVO vo;
		try {
			psmt = conn.prepareStatement("select * from shop");
			rs = psmt.executeQuery();
			
			while(rs.next()) {
				vo = new ShopVO();
				vo.setItemNo(rs.getString("item_no"));
				vo.setItemName(rs.getString("item_name"));
				vo.setItemDesc(rs.getString("item_desc"));
				vo.setLikeIt(rs.getDouble("like_it"));
				vo.setPrice(rs.getInt("price"));
				vo.setPriceOff(rs.getInt("price_off"));
				vo.setImage(rs.getString("image"));
				list.add(vo);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		
		return list;
	}
	
	public int insertItem(ShopVO vo) {
		int r = 0;
		String sql = "insert into shop(item_no, item_name, item_desc, like_it, price, price_off, image) values(?,?,?,?,?,?,?)";
		try {
			conn.setAutoCommit(false);
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getItemNo());
			psmt.setString(2, vo.getItemName());
			psmt.setString(3, vo.getItemDesc());
			psmt.setDouble(4, vo.getLikeIt());
			psmt.setInt(5, vo.getPrice());
			psmt.setInt(6, vo.getPriceOff());
			psmt.setString(7, vo.getImage());
			r = psmt.executeUpdate();
			System.out.println(r + "건 입력");
			conn.commit();
		} catch (SQLException e) {
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		} finally {
			disconnect();
		}
		return r;
	}
	
	public int deleteItem(String itemNo) {
		int r = 0;
		
		try {
			psmt = conn.prepareStatement("delete from shop where item_no=?");
			psmt.setString(1, itemNo);
			r = psmt.executeUpdate();
			System.out.println(r + "건 삭제");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return r;
	}
}
