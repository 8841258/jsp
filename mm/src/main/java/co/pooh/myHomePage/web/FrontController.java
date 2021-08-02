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
import co.pooh.myHomePage.command.MemberAccount;
import co.pooh.myHomePage.command.MemberInsert;
import co.pooh.myHomePage.command.MemberInsertForm;
import co.pooh.myHomePage.command.ToBoardDelete;
import co.pooh.myHomePage.command.ToBoardInsert;
import co.pooh.myHomePage.command.ToBoardList;
import co.pooh.myHomePage.command.ToBoardListd;
import co.pooh.myHomePage.command.ToBoardListi;
import co.pooh.myHomePage.command.FreeBoardCommentInsert;
import co.pooh.myHomePage.command.FreeBoardDelete;
import co.pooh.myHomePage.command.FreeBoardInsert;
import co.pooh.myHomePage.command.FreeBoardInsertForm;
import co.pooh.myHomePage.command.FreeBoardList;
import co.pooh.myHomePage.command.FreeBoardSelect;
import co.pooh.myHomePage.command.FreeBoardSelectbu;
import co.pooh.myHomePage.command.FreeBoardSelectci;
import co.pooh.myHomePage.command.FreeBoardUpdate;
import co.pooh.myHomePage.command.FreeBoardUpdateForm;
import co.pooh.myHomePage.command.FromBoardList;
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
		map.put("/freeBoardList.do", new FreeBoardList());
		map.put("/freeBoardSelect.do", new FreeBoardSelect());
		map.put("/memberAccount.do", new MemberAccount());
		map.put("/freeBoardInsertForm.do", new FreeBoardInsertForm());
		map.put("/freeBoardInsert.do", new FreeBoardInsert());
		map.put("/freeBoardDelete.do", new FreeBoardDelete());
		map.put("/freeBoardUpdateForm.do", new FreeBoardUpdateForm());
		map.put("/freeBoardUpdate.do", new FreeBoardUpdate());
		map.put("/fromBoardList.do", new FromBoardList());
		map.put("/toBoardList.do", new ToBoardList());
		map.put("/toBoardInsert.do", new ToBoardInsert());
		map.put("/toBoardDelete.do", new ToBoardDelete());
		map.put("/freeBoardCommentInsert.do", new FreeBoardCommentInsert());
		map.put("/freeBoardSelectci.do", new FreeBoardSelectci());
		map.put("/freeBoardSelectbu.do", new FreeBoardSelectbu());
		map.put("/toBoardListi.do", new ToBoardListi());
		map.put("/toBoardListd.do", new ToBoardListd());
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
		System.out.println(page);
		RequestDispatcher dispatcher = request.getRequestDispatcher(page);
		dispatcher.forward(request, response);
		
	}

}
