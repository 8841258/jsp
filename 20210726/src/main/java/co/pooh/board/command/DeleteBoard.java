package co.pooh.board.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.pooh.board.service.BoardService;
import co.pooh.board.serviceImpl.BoardServiceImpl;
import co.pooh.board.vo.BoardVO;

public class DeleteBoard implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO 게시글 삭제
		
		BoardService dao = new BoardServiceImpl();
		BoardVO vo = new BoardVO();
		
		vo.setbId(Integer.valueOf(request.getParameter("bId")));
		int n = dao.boardDelete(vo);
		
		String page = "";
		if (n != 0) {
			page = "boardList.do";
		} else {
			page = "board/boardUpdateFail";
		}
		
		return page;
	}

}
