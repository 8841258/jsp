package co.pooh.myHomePage.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import co.pooh.myHomePage.board.service.FMemberService;
import co.pooh.myHomePage.board.serviceImpl.FMemberServiceImpl;
import co.pooh.myHomePage.common.Command;
import co.pooh.myHomePage.fmember.vo.FMemberVO;

public class DeleteAccount implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		FMemberService dao = new FMemberServiceImpl();
		FMemberVO vo = new FMemberVO();
		HttpSession session = request.getSession();

		vo.setId((String) session.getAttribute("id"));
		dao.memberDelete(vo);
		session.invalidate();
		
		return "loginForm.do";
	}

}
