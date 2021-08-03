package co.pooh.myHomePage.command;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import co.pooh.myHomePage.board.service.FromBoardService;
import co.pooh.myHomePage.board.serviceImpl.FromBoardServiceImpl;
import co.pooh.myHomePage.board.vo.FromBoardVO;
import co.pooh.myHomePage.common.Command;
import co.pooh.myHomePage.fmember.vo.FMemberVO;

public class FromBoardList implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		FromBoardService dao = new FromBoardServiceImpl();
		List<FromBoardVO> list = new ArrayList<FromBoardVO>();
		FMemberVO vo = new FMemberVO();
		HttpSession session = request.getSession();
		vo.setNickname((String) session.getAttribute("nickname"));
		vo.setAuthor((String) session.getAttribute("author"));
		list = dao.fromBoardSelectList();
		request.setAttribute("list", list);
		request.setAttribute("member", vo);
		System.out.println(vo.getAuthor());
		
		return "home/fromBoardList";
	}
}
