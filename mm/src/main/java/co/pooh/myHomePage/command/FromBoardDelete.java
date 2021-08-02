package co.pooh.myHomePage.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import co.pooh.myHomePage.board.service.FromBoardService;
import co.pooh.myHomePage.board.serviceImpl.FromBoardServiceImpl;
import co.pooh.myHomePage.board.vo.FromBoardVO;
import co.pooh.myHomePage.common.Command;

public class FromBoardDelete implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		FromBoardService dao = new FromBoardServiceImpl();
		FromBoardVO vo = new FromBoardVO();
		
		HttpSession session = request.getSession();
		System.out.println(request.getParameter("fromno"));
		vo.setFromNo(Integer.valueOf(request.getParameter("fromno")));
		vo.setFromWriter((String) session.getAttribute("nickname"));
		
		dao.fromBoardDelete(vo);
		
		request.setAttribute("fromno", (Object) vo.getFromNo());
		
		return "fromBoardListd.do";
	}

}
