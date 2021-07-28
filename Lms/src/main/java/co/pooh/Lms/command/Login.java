package co.pooh.Lms.command;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import co.pooh.Lms.board.Service.BoardService;
import co.pooh.Lms.board.ServiceImpl.BoardServiceImpl;
import co.pooh.Lms.board.vo.BoardVO;
import co.pooh.Lms.member.service.MemberService;
import co.pooh.Lms.member.serviceImpl.MemberServiceImpl;
import co.pooh.Lms.member.vo.MemberVO;

public class Login implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		MemberService ms = new MemberServiceImpl();
		BoardService bs = new BoardServiceImpl();
		
		MemberVO vo = new MemberVO();
		
		HttpSession session = request.getSession();
		
		vo.setId(request.getParameter("id"));
		vo.setPassword(request.getParameter("password"));
		
		vo = ms.memberLogin(vo);
		
		String page = "";
		if (vo.getName() != null) {
			session.setAttribute("name", vo.getName());
			session.setAttribute("author", vo.getAuthor());
			session.setAttribute("id", vo.getId());
			
			List<BoardVO> list = bs.boardSelectList();
			request.setAttribute("boards", list);
			
			page = "main.do";
		} else {
			page = "loginForm.do";
		}
		
		return page;
	}

}
