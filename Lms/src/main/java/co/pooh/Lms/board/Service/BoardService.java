package co.pooh.Lms.board.Service;

import java.util.List;

import co.pooh.Lms.board.vo.BoardVO;

public interface BoardService {
	List<BoardVO> boardSelectList();
	
	BoardVO boardSelect(BoardVO vo);
	
	int boardInsert(BoardVO vo);
	
	int boardUpdate(BoardVO vo);
	
	int boardDelete(BoardVO vo);
}
