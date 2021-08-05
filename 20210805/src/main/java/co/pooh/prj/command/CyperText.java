package co.pooh.prj.command;

import java.security.NoSuchAlgorithmException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.pooh.prj.comm.Command;
import co.pooh.prj.comm.SHA_256;

public class CyperText implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		SHA_256 cyper = new SHA_256();
		String str = "Hellow1234"; //패스워드 가정하기.
		try {
			String cyperText = cyper.encrypt(str);
//			vo.setPassword(cyperText);
			System.out.println("원문 : " + str);
			System.out.println("암호문 : " + cyperText);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		
		return "";
	}

}
