package co.pooh.myHomePage.board.service;

import co.pooh.myHomePage.board.vo.FreeCommentVO;

public interface FreeCommentService {
	int freeBoardInsert(FreeCommentVO vo);
	
	int freeBoardDelete(FreeCommentVO vo);
}
