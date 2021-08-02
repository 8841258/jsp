package co.pooh.myHomePage.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.pooh.myHomePage.board.service.FreeBoardService;
import co.pooh.myHomePage.board.serviceImpl.FreeBoardServiceImpl;
import co.pooh.myHomePage.board.vo.FreeBoardVO;
import co.pooh.myHomePage.common.Command;

public class FreeBoardUpdate implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		FreeBoardService dao = new FreeBoardServiceImpl();
		FreeBoardVO vo = new FreeBoardVO();
		vo.setFreeNo(Integer.valueOf(request.getParameter("freeno")));
		System.out.println("겟파라미터 freeno : " + request.getParameter("freeno"));
		vo.setFreeTitle(request.getParameter("freetitle"));
		vo.setFreeContent(request.getParameter("freecontent"));
		dao.freeBoardUpdate(vo);
		System.out.println("dao 이후 freeno : " + vo.getFreeNo());
		request.setAttribute("freeno", (Object) vo.getFreeNo());
		return "freeBoardSelectbu.do";
	}

}
