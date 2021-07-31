package co.pooh.myHomePage.board.service;

import java.util.List;

import co.pooh.myHomePage.board.vo.FreeBoardVO;

public interface FreeBoardService {
	
	List<FreeBoardVO> freeBoardSelectList();
	
	List<FreeBoardVO> freeBoardSelect(int no);
	
	int freeBoardInsert(FreeBoardVO vo);
	
	int freeBoardUpdate(FreeBoardVO vo);
	
	int freeBoardDelete(FreeBoardVO vo);
	
}
