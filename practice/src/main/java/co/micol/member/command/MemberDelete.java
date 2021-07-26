package co.micol.member.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.micol.member.service.MemberService;
import co.micol.member.serviceImpl.MemberServiceImpl;
import co.micol.member.vo.MemberVO;

public class MemberDelete implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		MemberService ms = new MemberServiceImpl();
		MemberVO vo = new MemberVO();
		vo.setId(request.getParameter("id"));
		int r = ms.memberDelete(vo);
		String viewPage = "";
		if (r != 0) {
			viewPage = "memberList.do";
		} else {
			request.setAttribute("message", "삭제에 실패했습니다.");
			viewPage = "member/memberError";
		}
		return viewPage;
	}

}
