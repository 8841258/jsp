package co.pooh.prj.Command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import co.pooh.prj.common.Command;

public class Logout implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		String message = session.getAttribute("name") + "님 정상 로그아웃되었습니다.";
//		session.invalidate(); //세션을 삭제한다.(객체 자체를 지움) session.removeAttribute() -> 세션 유효아이디는 남기고 내용을 지움
		session.removeAttribute("name");
		session.removeAttribute("author");
		request.setAttribute("message", message);
		
		return "member/memberError";
	}

}
