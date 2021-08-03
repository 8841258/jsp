package co.pooh.myHomePage.board.service;

import java.util.List;

import co.pooh.myHomePage.board.vo.FromBoardVO;

public interface FromBoardService {
	List<FromBoardVO> fromBoardSelectList();
	
	int fromBoardInsert(FromBoardVO vo);
	
	int fromBoardDelete(FromBoardVO vo);
	
	
}
