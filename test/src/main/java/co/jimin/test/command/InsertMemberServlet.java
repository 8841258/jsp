package co.jimin.test.command;

import java.io.IOException;
import java.sql.Date;

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

@WebServlet("/InsertMemberServlet")
public class InsertMemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public InsertMemberServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		response.setCharacterEncoding("utf-8");
//		response.setContentType("text/json;charset=utf-8");
//		
//		MemberService dao = new MemberServiceImpl();
//		MemberVO vo = new MemberVO();
//		
//		vo.setMemberId(request.getParameter("memberId"));
//		vo.setMemberName(request.getParameter("memberName"));
//		vo.setMemberPhone(request.getParameter("memberPhone"));
//		vo.setMemberAddr(request.getParameter("memberAddr"));
//		vo.setMemberBirth(Date.valueOf(request.getParameter("memberBirth")));
//		
//		dao.memberInsert(vo);
//		
//		dao.memberSelectOne(vo);
//		
//		Gson gson = new GsonBuilder().create();
//		
//		response.getWriter().print(gson.toJson(vo));
		
	}

}
