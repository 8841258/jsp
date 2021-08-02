package co.pooh.myHomePage.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import co.pooh.myHomePage.board.service.FreeCommentService;
import co.pooh.myHomePage.board.serviceImpl.FreeCommentServiceImpl;
import co.pooh.myHomePage.board.vo.FreeCommentVO;
import co.pooh.myHomePage.common.Command;

public class FreeBoardCommentInsert implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		FreeCommentService dao = new FreeCommentServiceImpl();
		FreeCommentVO vo = new FreeCommentVO();
		
		HttpSession session = request.getSession();
		
		vo.setFreeNO(Integer.valueOf(request.getParameter("freeno")));
		vo.setFreeCwriter((String) session.getAttribute("nickname"));
		vo.setFreeCcontent(request.getParameter("freeccontent"));
		
		dao.freeBoardInsert(vo);
		
		request.setAttribute("freeno", (Object) vo.getFreeNO());
		
		return "freeBoardSelectci.do";
	}

}
