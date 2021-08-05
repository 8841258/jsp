package co.pooh.prj.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.pooh.prj.comm.Command;
import co.pooh.prj.comm.DownLoadFile;

public class FileDownLoad implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		System.out.println(request.getParameter("orgFile"));
		System.out.println(request.getParameter("downFile"));
		
		String path = "d://temp";
		String orgFileName = request.getParameter("orgFile");
		String downFileName = request.getParameter("downFile");
		DownLoadFile downLoadFile = new DownLoadFile(path, orgFileName, downFileName);
		
		boolean b = downLoadFile.isFileDown();
		
		if (!b) {
			request.setAttribute("message", "파일이 성공적으로 다운로드 되었습니다.");
		} else {
			request.setAttribute("message", "파일이 다운로드 되지 않았습니다.");
		}
		
		return "fileList.do";
	}

}
