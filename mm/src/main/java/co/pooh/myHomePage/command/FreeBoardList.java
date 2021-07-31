package co.pooh.myHomePage.command;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.pooh.myHomePage.board.service.FreeBoardService;
import co.pooh.myHomePage.board.serviceImpl.FreeBoardServiceImpl;
import co.pooh.myHomePage.board.vo.FreeBoardVO;
import co.pooh.myHomePage.common.Command;

public class FreeBoardList implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		FreeBoardService dao = new FreeBoardServiceImpl();
		List<FreeBoardVO> list = new ArrayList<FreeBoardVO>();
		list = dao.freeBoardSelectList();
		request.setAttribute("list", list);
		return "home/freeBoardList";
	}

}
