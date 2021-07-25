package co.micol.member.web;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.micol.member.command.Command;
import co.micol.member.command.MainCommand;
import co.micol.member.command.MemberDelete;
import co.micol.member.command.MemberDeleteForm;
import co.micol.member.command.MemberInsert;
import co.micol.member.command.MemberInsertForm;
import co.micol.member.command.MemberListCommand;
import co.micol.member.command.MemberSearchCommand;
import co.micol.member.command.MemberSearchForm;
import co.micol.member.command.MemberUpdate;
import co.micol.member.command.MemberUpdateForm;

//@WebServlet("/FrontController")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private HashMap<String, Command> map = new HashMap<String, Command>();   
	
    public FrontController() {
        super();
    }

	public void init(ServletConfig config) throws ServletException {
		// TODO Command 객체를 여기다 등록
		map.put("/main.do", new MainCommand());
		map.put("/memberList.do", new MemberListCommand());
		map.put("/memberSearchForm.do", new MemberSearchForm());
		map.put("/memberSearch.do", new MemberSearchCommand());
		map.put("/memberInsertForm.do", new MemberInsertForm());
		map.put("/memberInsert.do", new MemberInsert());
		map.put("/memberUpdateForm.do", new MemberUpdateForm());
		map.put("/memberUpdate.do", new MemberUpdate());
		map.put("/memberDeleteForm.do", new MemberDeleteForm());
		map.put("/memberDelete.do", new MemberDelete());
	}

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO 여기에서 요청분석 및 처리, view Page 선택
		request.setCharacterEncoding("utf-8");
		
		String path = request.getServletPath(); // path = test~
		
		Command command = map.get(path);
		String viewPage = command.execute(request, response);
		
		//굳이 이 조건을 걸어줘야 할 이유가 뭘까....
		if (!viewPage.endsWith(".do")) {
			viewPage = "WEB-INF/views/" + viewPage + ".jsp";
			
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);
	}

}
