package co.pooh.myHomePage.board.service;

import java.util.List;

import co.pooh.myHomePage.board.vo.ToBoardVO;

public interface ToBoardService {
	List<ToBoardVO> toBoardSelectList();
	
	int toBoardInsert(ToBoardVO vo);
	
	int toBoardDelete(ToBoardVO vo);
	
}
