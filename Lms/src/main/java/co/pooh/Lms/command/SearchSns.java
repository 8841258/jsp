package co.pooh.Lms.command;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.pooh.Lms.sns.service.SnsService;
import co.pooh.Lms.sns.serviceImpl.SnsServiceImpl;
import co.pooh.Lms.sns.vo.SnsVO;

public class SearchSns implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO 선택된 sns 글을 가져온다
		SnsService dao = new SnsServiceImpl();
		
		List<SnsVO> list = new ArrayList<SnsVO>();
		int n = Integer.valueOf(request.getParameter("sNo"));
		list = dao.snsSelect(n);
		request.setAttribute("list", list);
		
		
		return "main/snsDetail";
	}

}
