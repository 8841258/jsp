package co.micol.member.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.micol.member.service.MemberService;
import co.micol.member.serviceImpl.MemberServiceImpl;
import co.micol.member.vo.MemberVO;

public class MemberSearchCommand implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		MemberService ms = new MemberServiceImpl();
		MemberVO vo = new MemberVO();
		vo.setId(request.getParameter("id"));
		vo = ms.memberSelect(vo);
		
		//아이디 검색 결과가 있으면 vo 객체를 가지고 간다.
		if (vo.getName() != null) {
			request.setAttribute("member", vo);
		} else {
		//아이디가 DB에 없으면 이 메시지를 가지고 간다.
			request.setAttribute("message", "존재하지 않는 아이디입니다.");
		}
		
		return "member/memberSearch";
	}

}
