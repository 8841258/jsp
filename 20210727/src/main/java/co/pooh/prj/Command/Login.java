package co.pooh.prj.Command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import co.pooh.prj.common.Command;
import co.pooh.prj.member.Service.MemberService;
import co.pooh.prj.member.ServiceImpl.MemberServiceImpl;
import co.pooh.prj.member.vo.MemberVO;

public class Login implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO 로그인 과정을 처리하는 곳
		MemberService ms = new MemberServiceImpl();
		MemberVO vo = new MemberVO();
		//세션세션세션세션세션세션세션세션세션세션세션세션세션세션세션세션세션세션 서버가 가지고 있는 세션 객체를 호출
		HttpSession session = request.getSession();
		
		System.out.println(session.getId() + "=======================================");
		
		vo.setId(request.getParameter("id"));
		vo.setPassword(request.getParameter("password"));
		
		vo = ms.memberLogin(vo);
		
		String page = "";
		
		//로그인이 성공하면(이름을 가져오면) 세션에 담는다.
		if (vo.getName() != null) { //vo.getName().isEmpty()
			session.setAttribute("name", vo.getName());
			session.setAttribute("author", vo.getAuthor());
			session.setAttribute("id", vo.getId());
			
			page = "member/loginSuccess";
			
		} else {
			String message = "아이디 또는 패스워드가 틀립니다.";
			request.setAttribute("message", message);
			
			page = "member/memberError";
		}
		
		return page;
	}

}
