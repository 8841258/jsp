package co.pooh.myHomePage.board.service;

import java.util.List;

import co.pooh.myHomePage.fmember.vo.FMemberVO;

public interface FMemberService {
	
	List<FMemberVO> memberSelectList();
	
	FMemberVO login(FMemberVO vo);
	
	int memberInsert(FMemberVO vo);
	
	int memberDelete(FMemberVO vo);
	
	FMemberVO memberAccount(FMemberVO vo);
}
