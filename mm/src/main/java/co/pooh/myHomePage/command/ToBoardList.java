package co.pooh.myHomePage.command;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.pooh.myHomePage.board.service.ToBoardService;
import co.pooh.myHomePage.board.serviceImpl.ToBoardServiceImpl;
import co.pooh.myHomePage.board.vo.ToBoardVO;
import co.pooh.myHomePage.common.Command;

public class ToBoardList implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		ToBoardService dao = new ToBoardServiceImpl();
		List<ToBoardVO> list = new ArrayList<ToBoardVO>();
		list = dao.toBoardSelectList();
		request.setAttribute("list", list);
		return "home/toBoardList";
	}

}
