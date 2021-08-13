package co.yedam.shop;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/DeleteItemServlet.do")
public class DeleteItemServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public DeleteItemServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String itemNo = request.getParameter("itemNo");
		System.out.println(itemNo);
		ShopDAO dao = new ShopDAO();
		dao.deleteItem(itemNo);
		
	}

}
