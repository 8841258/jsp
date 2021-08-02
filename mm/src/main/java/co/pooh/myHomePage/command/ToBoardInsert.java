package co.pooh.myHomePage.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import co.pooh.myHomePage.board.service.ToBoardService;
import co.pooh.myHomePage.board.serviceImpl.ToBoardServiceImpl;
import co.pooh.myHomePage.board.vo.ToBoardVO;
import co.pooh.myHomePage.common.Command;

public class ToBoardInsert implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		ToBoardService dao = new ToBoardServiceImpl();
		ToBoardVO vo = new ToBoardVO();
		
		HttpSession session = request.getSession();
		
		vo.setToWriter((String) session.getAttribute("nickname"));
		vo.setToContent(request.getParameter("tocontent"));
		
		dao.toBoardInsert(vo);
		
		request.setAttribute("tono", (Object) vo.getToNo());
		
		return "toBoardListi.do";
	}

}
