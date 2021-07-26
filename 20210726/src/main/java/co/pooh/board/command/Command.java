package co.pooh.board.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Command {
	//실제로 명령을 받아서 동작되는 곳
	//리턴값은 페이지
	
	public String execute(HttpServletRequest request, HttpServletResponse response);
}
