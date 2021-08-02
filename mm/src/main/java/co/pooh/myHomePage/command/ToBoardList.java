package co.pooh.myHomePage.command;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import co.pooh.myHomePage.board.service.ToBoardService;
import co.pooh.myHomePage.board.serviceImpl.ToBoardServiceImpl;
import co.pooh.myHomePage.board.vo.ToBoardVO;
import co.pooh.myHomePage.common.Command;
import co.pooh.myHomePage.fmember.vo.FMemberVO;

public class ToBoardList implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		ToBoardService dao = new ToBoardServiceImpl();
		List<ToBoardVO> list = new ArrayList<ToBoardVO>();
		FMemberVO vo = new FMemberVO();
		HttpSession session = request.getSession();
		vo.setNickname((String) session.getAttribute("nickname"));
		vo.setAuthor((String) session.getAttribute("author"));
		list = dao.toBoardSelectList();
		request.setAttribute("list", list);
		request.setAttribute("member", vo);
		
		return "home/toBoardList";
		
	}

}
