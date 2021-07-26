package co.pooh.board.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.pooh.board.service.BoardService;
import co.pooh.board.serviceImpl.BoardServiceImpl;
import co.pooh.board.vo.BoardVO;

public class UpdateForm implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		BoardService dao = new BoardServiceImpl();
		BoardVO vo = new BoardVO();
		vo.setbId(Integer.valueOf(request.getParameter("bId")));
		vo = dao.boardSelect(vo);
		request.setAttribute("board", vo);
		
		return "board/updateForm";
	}

}
