package co.micol.member.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.micol.member.service.MemberService;
import co.micol.member.serviceImpl.MemberServiceImpl;
import co.micol.member.vo.MemberVO;

public class MemberUpdate implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		MemberService ms = new MemberServiceImpl();
		MemberVO vo = new MemberVO();
		vo.setId(request.getParameter("id"));
		vo.setPassword(request.getParameter("password"));
		String[] hobbys = request.getParameterValues("hobbys");
		String hobby = "";
		for (String h : hobbys) {
			hobby += h + ",";
		}
		hobby = hobby.substring(0, hobby.length() - 1);
		vo.setHobby(hobby);
		int r = ms.memberUpdate(vo);

		String str = "";

		if (r != 0) {
			str = "memberList.do";
		} else {
			request.setAttribute("message", "수정에 실패했습니다.");
			str = "member/memberError";
		}

		return str;
	}

}
