package co.pooh.prj.command;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import co.pooh.prj.comm.Command;
import co.pooh.prj.image.service.FileInfoService;
import co.pooh.prj.image.vo.FileInformationVO;


public class FileUpload implements Command {
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		//파일업로드
		FileInfoService fileDao = new FileInfoService();
		FileInformationVO vo = new FileInformationVO();
		int maxFileSize = 1024 * 1024 * 100;
		try {
			//보낼 때 multipart로 보냈기 때문에 리퀘스트도 이렇게 받는듯...
			MultipartRequest part = new MultipartRequest(request, "d:/temp/", maxFileSize, "utf-8", new DefaultFileRenamePolicy());
			String orgFileName = part.getOriginalFileName("fileName"); //원래 파일명
			String upFileName = part.getFilesystemName("fileName"); //업로드한 파일명
			
			vo.setSubject(part.getParameter("subject"));
			vo.setFileName(orgFileName);
			vo.setDownFile(upFileName);
			int n = fileDao.FileInsert(vo);
			
			if (n != 0) {
				request.setAttribute("message", vo.getFileName() + "파일 업로드 성공");
			} else {
				request.setAttribute("message", orgFileName + "파일 업로드 실패");
			}		
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return "file/fileUploadResult";
	}

}
