package co.pooh.myHomePage.command;

import java.util.Enumeration;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import co.pooh.myHomePage.board.service.FreeBoardService;
import co.pooh.myHomePage.board.serviceImpl.FreeBoardServiceImpl;
import co.pooh.myHomePage.board.vo.FreeBoardVO;
import co.pooh.myHomePage.common.Command;

public class FreeBoardInsert implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		
		String realFolder = "";
		String filename1 = "";
		int maxSize = 1024 * 1024 * 5;
		String encType = "euc-kr";
		String savefile = "img";
		ServletContext scontext = request.getServletContext();
		realFolder = scontext.getRealPath(savefile);

		try {
			MultipartRequest multi = new MultipartRequest(request, realFolder, maxSize, encType,
					new DefaultFileRenamePolicy());

			Enumeration<?> files = multi.getFileNames();
			String file1 = (String) files.nextElement();
			filename1 = multi.getFilesystemName(file1);
		} catch (Exception e) {
			e.printStackTrace();
		}

		String fullpath = realFolder + "\\" + filename1;
		
		//freeboard에 이 경로를 저장하는 컬럼을 하나 만들고...거기에 insert를 같이 하는 방식으로....
		
		
		
		FreeBoardService dao = new FreeBoardServiceImpl();
		FreeBoardVO vo = new FreeBoardVO();
		
		HttpSession session = request.getSession();
		
		vo.setFreeWriter((String) session.getAttribute("nickname"));
		vo.setFreeTitle(request.getParameter("freetitle"));
		vo.setFreeContent(request.getParameter("freecontent"));
		vo.setFreeFile(fullpath);
		
		System.out.println((String) session.getAttribute("nickname"));
		System.out.println(request.getParameter("freetitle"));
		System.out.println(request.getParameter("freecontent"));
		System.out.println(vo.getFreeFile());
		
		dao.freeBoardInsert(vo);
		
		return "freeBoardList.do";
	}

}
