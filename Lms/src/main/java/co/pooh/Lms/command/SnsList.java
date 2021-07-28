package co.pooh.Lms.command;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.pooh.Lms.sns.service.SnsService;
import co.pooh.Lms.sns.serviceImpl.SnsServiceImpl;
import co.pooh.Lms.sns.vo.SnsVO;

public class SnsList implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO SNS 리스트
		SnsService dao = new SnsServiceImpl();
		List<SnsVO> list = new ArrayList<SnsVO>();
		list = dao.snsSelectList();
		request.setAttribute("list", list);
		
		
		return "main/snsList";
	}

}
