package co.jimin.test.service;

import java.util.List;

import co.jimin.test.vo.MemberVO;

public interface MemberService {
	List<MemberVO> memberSelect();
	
	int memberInsert(MemberVO vo);
	
	int memberUpdate(MemberVO vo);
	
	int memberDelete(MemberVO vo);
}
