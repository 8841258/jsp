package co.micol.member.service;

import java.util.List;

import co.micol.member.vo.MemberVO;

public interface MemberService {
	List<MemberVO> memberSelectList(); //회원 전체 목록 보기 (R)
	
	MemberVO memberSelect(MemberVO vo); //한 명 조회 (R)
	
	int memberInsert(MemberVO vo); //회원 추가 (C)
	
	int memberDelete(MemberVO vo); //회원 삭제 (D)
	
	int memberUpdate(MemberVO vo); //회원 정보 변경 (U)

	
}
