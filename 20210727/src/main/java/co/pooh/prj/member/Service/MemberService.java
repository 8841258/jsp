package co.pooh.prj.member.Service;

import java.util.List;

import co.pooh.prj.member.vo.MemberVO;

public interface MemberService {
	List<MemberVO> memberSelectList();
	
	MemberVO memberSelect(MemberVO vo);
	
	MemberVO memberLogin(MemberVO vo); //로그인
	
	int memberInsert(MemberVO vo);
	
	int memberUpdate(MemberVO vo);
	
	int memberDelete(MemberVO vo);
}
