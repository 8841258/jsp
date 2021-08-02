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

public class ToBoardListi implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		ToBoardService dao = new ToBoardServiceImpl();
		
		//세션 보내기
		FMemberVO vo = new FMemberVO();
		HttpSession session = request.getSession();	
		vo.setAuthor((String) session.getAttribute("author"));
		request.setAttribute("member", vo);
		
		int n = (int) request.getAttribute("tono");
		List<ToBoardVO> list = new ArrayList<ToBoardVO>();
		list = dao.toBoardSelectList();
		request.setAttribute("list", list);
		
		return "home/toBoardList";
	}

}
