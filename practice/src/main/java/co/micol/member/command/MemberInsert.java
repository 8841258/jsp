package co.micol.member.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.micol.member.service.MemberService;
import co.micol.member.serviceImpl.MemberServiceImpl;
import co.micol.member.vo.MemberVO;

public class MemberInsert implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		MemberVO vo = new MemberVO();
		MemberService ms = new MemberServiceImpl();
		vo.setId(request.getParameter("id"));
		vo.setPassword(request.getParameter("password"));
		vo.setName(request.getParameter("name"));
		vo.setAge(Integer.valueOf(request.getParameter("age"))); //웹페이지에서 넘어온 값은 모두 문자열로 보기 때문에 integer로 형변환.
		String[] hobbys = request.getParameterValues("hobbys");
		String hobby = "";
		for (String h : hobbys) {
			hobby += h + ",";
		}
		hobby = hobby.substring(0, hobby.length()-1);
		vo.setHobby(hobby);
		
		int r = ms.memberInsert(vo);
		String str;
		
		if (r != 0) {
			str = "memberList.do";
		} else {
			request.setAttribute("message", "입력이 실패했습니다.");
			str = "member/memberError";
		}
		
		return str;
	}

}
