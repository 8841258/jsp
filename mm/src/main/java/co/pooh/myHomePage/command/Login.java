package co.pooh.myHomePage.command;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import co.pooh.myHomePage.board.service.FMemberService;
import co.pooh.myHomePage.board.serviceImpl.FMemberServiceImpl;
import co.pooh.myHomePage.common.Command;
import co.pooh.myHomePage.fmember.vo.FMemberVO;

public class Login implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		FMemberService dao = new FMemberServiceImpl();
		FMemberVO vo = new FMemberVO();
		
		HttpSession session = request.getSession();
		
		vo.setId(request.getParameter("id"));
		vo.setPassword(request.getParameter("password"));
		
		vo = dao.login(vo);
		
		String page = "";
		if (vo.getNickname() != null) {
			session.setAttribute("nickname", vo.getName());
			session.setAttribute("author", vo.getAuthor());
			request.setAttribute("login", vo);
			
			page = "home.do";
		} else {
			page = "loginForm.do";
		}
		
		return page;
	}

}
