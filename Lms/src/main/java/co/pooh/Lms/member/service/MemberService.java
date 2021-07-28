package co.pooh.Lms.member.service;

import java.util.List;

import co.pooh.Lms.member.vo.MemberVO;

public interface MemberService {
	List<MemberVO> memberSelectList();
	
	MemberVO memberSelect(MemberVO vo);
	
	MemberVO memberLogin(MemberVO vo);
	
	int memberInsert(MemberVO vo);
	
	int memberUpdate(MemberVO vo);
	
	int memberDelete(MemberVO vo);
}
