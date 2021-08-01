package co.pooh.myHomePage.command;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.pooh.myHomePage.board.service.FromBoardService;
import co.pooh.myHomePage.board.serviceImpl.FromBoardServiceImpl;
import co.pooh.myHomePage.board.vo.FromBoardVO;
import co.pooh.myHomePage.common.Command;

public class FromBoardList implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		FromBoardService dao = new FromBoardServiceImpl();
		List<FromBoardVO> list = new ArrayList<FromBoardVO>();
		list = dao.fromBoardSelectList();
		request.setAttribute("list", list);
		return "home/fromBoardList";
	}
}
