package co.pooh.myHomePage.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import co.pooh.myHomePage.board.service.FromBoardService;
import co.pooh.myHomePage.board.serviceImpl.FromBoardServiceImpl;
import co.pooh.myHomePage.board.vo.FromBoardVO;
import co.pooh.myHomePage.common.Command;

public class FromBoardInsert implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		FromBoardService dao = new FromBoardServiceImpl();
		FromBoardVO vo = new FromBoardVO();
		
		HttpSession session = request.getSession();
		
		vo.setFromWriter((String) session.getAttribute("nickname"));
		vo.setFromContent(request.getParameter("fromcontent"));
		
		dao.fromBoardInsert(vo);
		
		request.setAttribute("fromno", (Object) vo.getFromNo());
		
		return "fromBoardListi.do";
	}

}
