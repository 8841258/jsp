package co.pooh.prj.comm;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class DownLoadFile {
	 private String path;
	 private String orgFileName;
	 private String downFileName;
	 
	 public DownLoadFile(String path, String orgFileName, String downFileName) {
		this.path = path;
		this.orgFileName = orgFileName;
		this.downFileName = downFileName;
	 }
	 
	 public boolean isFileDown() {
		 boolean bool = true; //성공하면 false, 실패하면 true
		 File file = new File(path+File.separator+downFileName); // 이건 실제로는 => d:/temp/파일명
		 FileInputStream in;
		 try {
			in = new FileInputStream(file);
			FileOutputStream outFile = new FileOutputStream("d://download//" + orgFileName);
			byte b[] = new byte[4096];
			int data = 0;
			while ((data = in.read(b, 0, b.length)) != -1) {
				outFile.write(b, 0, data);
			}
			outFile.flush();
			in.close();
			outFile.close();
			
			bool = false;
		} catch (Exception e) {
			e.printStackTrace();
		}
		  
		 return bool;
	 }
	 
}
