package co.pooh.myHomePage.command;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.pooh.myHomePage.board.service.FMemberService;
import co.pooh.myHomePage.board.serviceImpl.FMemberServiceImpl;
import co.pooh.myHomePage.common.Command;
import co.pooh.myHomePage.fmember.vo.FMemberVO;

public class MemberManage implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		FMemberService dao = new FMemberServiceImpl();
		List<FMemberVO> list = new ArrayList<FMemberVO>();
		list = dao.memberSelectList();
		request.setAttribute("list", list);
		return "home/memberManage";
	}

}
