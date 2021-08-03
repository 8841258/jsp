package co.pooh.myHomePage.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import co.pooh.myHomePage.board.service.FreeBoardService;
import co.pooh.myHomePage.board.serviceImpl.FreeBoardServiceImpl;
import co.pooh.myHomePage.board.vo.FreeBoardVO;
import co.pooh.myHomePage.common.Command;

public class FreeBoardInsert implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		
		FreeBoardService dao = new FreeBoardServiceImpl();
		FreeBoardVO vo = new FreeBoardVO();
		
		HttpSession session = request.getSession();
		
		vo.setFreeWriter((String) session.getAttribute("nickname"));
		vo.setFreeTitle(request.getParameter("freetitle"));
		vo.setFreeContent(request.getParameter("freecontent"));
		
		System.out.println((String) session.getAttribute("nickname"));
		System.out.println(request.getParameter("freetitle"));
		System.out.println(request.getParameter("freecontent"));
		System.out.println(vo.getFreeFile());
		
		dao.freeBoardInsert(vo);
		
		return "freeBoardList.do";
	}

}
