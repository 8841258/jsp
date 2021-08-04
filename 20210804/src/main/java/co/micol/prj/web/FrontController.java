package co.micol.prj.web;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.micol.prj.command.Home;
import co.micol.prj.command.Login;
import co.micol.prj.command.MemberSearch;
import co.micol.prj.command.SnsList;
import co.micol.prj.command.SnsSelect;
import co.micol.prj.common.Command;

@WebServlet("*.do")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	HashMap<String, Command> map = new HashMap<String, Command>();
       
    public FrontController() {
        super();
    }

	public void init(ServletConfig config) throws ServletException {
		map.put("/home.do", new Home());
		map.put("/snsList.do", new SnsList());
		map.put("/snsSelect.do", new SnsSelect());
		map.put("/login.do", new Login());
		map.put("/memberSearch.do", new MemberSearch());
	}

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String path = request.getServletPath();
		
		Command command = map.get(path);
		String page = command.execute(request, response);
		
		if (!page.endsWith(".do")) {
			page = "WEB-INF/views/" + page + ".jsp";
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(page);
		dispatcher.forward(request, response);

		
	}

}
