package co.pooh.board.command;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.pooh.board.service.BoardService;
import co.pooh.board.serviceImpl.BoardServiceImpl;
import co.pooh.board.vo.BoardVO;

public class BoardList implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO 게시판 목록을 보여준다.
		BoardService dao = new BoardServiceImpl();
		List<BoardVO> list = new ArrayList<BoardVO>();
		list = dao.boardSelectList();
		
		request.setAttribute("boards", list);
		
		return "board/boardList";
	}

}
