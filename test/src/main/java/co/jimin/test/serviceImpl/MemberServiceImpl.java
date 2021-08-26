package co.jimin.test.serviceImpl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import co.jimin.test.common.DataSource;
import co.jimin.test.service.MemberMapper;
import co.jimin.test.service.MemberService;
import co.jimin.test.vo.MemberVO;

public class MemberServiceImpl implements MemberService {
	private SqlSession sqlSession = DataSource.getInstance().openSession(true);
	private MemberMapper map = sqlSession.getMapper(MemberMapper.class);
	
	@Override
	public List<MemberVO> memberSelect() {
		// TODO Auto-generated method stub
		return map.memberSelect();
	}

	@Override
	public int memberInsert(MemberVO vo) {
		// TODO Auto-generated method stub
		return map.memberInsert(vo);
	}

	@Override
	public int memberUpdate(MemberVO vo) {
		// TODO Auto-generated method stub
		return map.memberUpdate(vo);
	}

	@Override
	public int memberDelete(MemberVO vo) {
		// TODO Auto-generated method stub
		return map.memberDelete(vo);
	}

}
