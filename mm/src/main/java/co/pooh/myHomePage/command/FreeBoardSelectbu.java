package co.pooh.myHomePage.command;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import co.pooh.myHomePage.board.service.FreeBoardService;
import co.pooh.myHomePage.board.serviceImpl.FreeBoardServiceImpl;
import co.pooh.myHomePage.board.vo.FreeBoardVO;
import co.pooh.myHomePage.common.Command;
import co.pooh.myHomePage.fmember.vo.FMemberVO;

public class FreeBoardSelectbu implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		FreeBoardService dao = new FreeBoardServiceImpl();
		
		//세션 보내기
		FMemberVO vo = new FMemberVO();
		HttpSession session = request.getSession();	
		vo.setNickname((String) session.getAttribute("nickname"));
		request.setAttribute("member", vo);
		
		int n = (int) request.getAttribute("freeno");
		List<FreeBoardVO> list = new ArrayList<FreeBoardVO>();
		list = dao.freeBoardSelect(n);
		request.setAttribute("board", list);
		
		return "home/freeBoardSelect";
	}

}
