package co.pooh.prj.web;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.pooh.prj.comm.Command;
import co.pooh.prj.command.CyperText;
import co.pooh.prj.command.FileDownLoad;
import co.pooh.prj.command.FileList;
import co.pooh.prj.command.FileUpload;
import co.pooh.prj.command.Home;

@WebServlet("*.do")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	HashMap<String, Command> map = new HashMap<String, Command>();
       
    public FrontController() {
        super();
        // TODO Auto-generated constructor stub
    }

	public void init(ServletConfig config) throws ServletException {
		map.put("/home.do", new Home());
		map.put("/fileUpload.do", new FileUpload());
		map.put("/fileUploadForm.do", new FileUploadForm());
		map.put("/fileList.do", new FileList());
		map.put("/fileDownLoad.do", new FileDownLoad());
		map.put("/cyperText.do", new CyperText());
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
