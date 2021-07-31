package co.pooh.myHomePage.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.pooh.myHomePage.board.service.FMemberService;
import co.pooh.myHomePage.board.serviceImpl.FMemberServiceImpl;
import co.pooh.myHomePage.common.Command;
import co.pooh.myHomePage.fmember.vo.FMemberVO;

public class MemberInsert implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		FMemberService dao = new FMemberServiceImpl();
		FMemberVO vo = new FMemberVO();
		vo.setId(request.getParameter("id"));
		vo.setPassword(request.getParameter("password"));
		vo.setNickname(request.getParameter("nickname"));
		vo.setName(request.getParameter("name"));
		vo.setEmail(request.getParameter("email"));

		dao.memberInsert(vo);

		// 모달창 띄울 수 있으면 좋겠네용(회원가입이 완료되었습니다. 로그인해주세요.)
		// 실패하면 실패 페이지...그런데 !=null 할 값을 어디서 가져오지??login에서??

		return "home/loginForm.jsp";
	}
}