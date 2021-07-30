package co.pooh.myHomePage.board.service;

import java.util.List;

import co.pooh.myHomePage.board.vo.FreeBoardVO;

public interface FreeBoardService {
	List<FreeBoardVO> freeBoardSelectList();
	
	FreeBoardVO freeBoardSelect(FreeBoardVO vo);
	
	int freeBoardInsert(FreeBoardVO vo);
	
	int freeBoardUpdate(FreeBoardVO vo);
	
	int freeBoardDelete(FreeBoardVO vo);
}
