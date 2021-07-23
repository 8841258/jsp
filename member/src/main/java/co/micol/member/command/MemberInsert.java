package co.micol.member.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.micol.member.service.MemberService;
import co.micol.member.serviceImpl.MemberServiceImpl;
import co.micol.member.vo.MemberVO;

public class MemberInsert implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO 회원가입 메소드
		MemberService dao = new MemberServiceImpl();
		MemberVO vo = new MemberVO();
		String[] hobbys = request.getParameterValues("hobbys");
		String hobby = "";
		for (String str : hobbys) {
			hobby += str + ",";
		}
		hobby = hobby.substring(0, hobby.length()-1);
		vo.setId(request.getParameter("id"));
		vo.setPassword(request.getParameter("password"));
		vo.setName(request.getParameter("name"));
		vo.setAge(Integer.valueOf(request.getParameter("age"))); //웹페이지에서 넘어온 값은 다 문자열로 보기 때문
		vo.setHobby(hobby);
		int n = dao.memberInsert(vo);
		String view;
		if (n != 0) {
			view = "memberList.do";
		} else {
			request.setAttribute("message", "입력이 실패했습니다.");
			view = "member/memberInsertFail";
		}
		return view;
	}

}
