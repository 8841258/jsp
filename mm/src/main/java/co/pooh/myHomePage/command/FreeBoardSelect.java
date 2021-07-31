package co.pooh.myHomePage.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.pooh.myHomePage.board.service.FreeBoardService;
import co.pooh.myHomePage.board.serviceImpl.FreeBoardServiceImpl;
import co.pooh.myHomePage.board.vo.FreeBoardVO;
import co.pooh.myHomePage.common.Command;

public class FreeBoardSelect implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		FreeBoardService dao = new FreeBoardServiceImpl();
		FreeBoardVO vo = new FreeBoardVO();
		vo.setFreeNo(Integer.valueOf(request.getParameter("freeNo")));
		vo = dao.freeBoardSelect(vo);
		request.setAttribute("board", vo);
		
		return "home/freeBoardSelect";
	}

}
