package co.pooh.myHomePage.web;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.pooh.myHomePage.board.service.FreeBoardService;
import co.pooh.myHomePage.board.serviceImpl.FreeBoardServiceImpl;
import co.pooh.myHomePage.board.vo.FreeBoardVO;
import co.pooh.myHomePage.common.Command;

public class FreeBoardSelectcd implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		FreeBoardService dao = new FreeBoardServiceImpl();

		int n = (int) request.getAttribute("freeno");
		List<FreeBoardVO> list = new ArrayList<FreeBoardVO>();
		list = dao.freeBoardSelect(n);
		request.setAttribute("board", list);

		return "home/freeBoardSelect";
	}

}
