package co.pooh.myHomePage.web;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.pooh.myHomePage.command.Home;
import co.pooh.myHomePage.command.Login;
import co.pooh.myHomePage.command.LoginForm;
import co.pooh.myHomePage.command.Logout;
import co.pooh.myHomePage.command.MemberInsert;
import co.pooh.myHomePage.command.MemberInsertForm;
import co.pooh.myHomePage.common.Command;


public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private HashMap<String, Command> map = new HashMap<String, Command>();
       
    public FrontController() {
        super();
        // TODO Auto-generated constructor stub
    }

	public void init(ServletConfig config) throws ServletException {
		map.put("/home.do", new Home());
		map.put("/loginForm.do", new LoginForm());
		map.put("/memberInsertForm.do", new MemberInsertForm());
		map.put("/login.do", new Login());
		map.put("/memberInsert.do", new MemberInsert());
		map.put("/logout.do", new Logout());
	}

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String path = request.getServletPath();
		
		Command command = map.get(path);
		String page = command.execute(request, response);
		
		if (!page.endsWith(".do")) {  //home.do면 빠져나감
			if (!page.endsWith(".jsp")) {
				page = page + ".tiles";  //home/home
			} else {
				page = "/WEB-INF/views/" + page;    //home/home.jsp
				
			}
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(page);
		dispatcher.forward(request, response);
		
		
	}

}