package co.pooh.myHomePage.board.service;

import co.pooh.myHomePage.fmember.vo.FMemberVO;

public interface FMemberService {
	
	FMemberVO login(FMemberVO vo);
	
	int memberInsert(FMemberVO vo);
	
	int memberDelete(FMemberVO vo);
	
	FMemberVO memberAccount(FMemberVO vo);
}
