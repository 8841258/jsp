package co.jimin.test.command;

import java.io.IOException;

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

@WebServlet("/SelectOneMemberServlet")
public class SelectOneMemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public SelectOneMemberServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String memberId = request.getParameter("memberId");
		
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/json;charset=utf-8");
		
		MemberService dao = new MemberServiceImpl();
		MemberVO vo = new MemberVO();
		vo.setMemberId(memberId);
		vo = dao.memberSelectOne(vo);
		
		Gson gson = new GsonBuilder().create();
		response.getWriter().print(gson.toJson(vo));
	}

}
