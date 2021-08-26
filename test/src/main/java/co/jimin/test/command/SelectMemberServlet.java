package co.jimin.test.command;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import co.jimin.test.service.MemberService;
import co.jimin.test.serviceImpl.MemberServiceImpl;
import co.jimin.test.vo.MemberVO;

/**
 * Servlet implementation class SelectMemberServlet
 */
@WebServlet("/SelectMemberServlet")
public class SelectMemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public SelectMemberServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/json;charset=utf-8");
		
		MemberService dao = new MemberServiceImpl();
		List<MemberVO> list = dao.memberSelect();
		
		Gson gson = new GsonBuilder().create();
		
		response.getWriter().print(gson.toJson(list));
		
		
	}

}
