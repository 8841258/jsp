package co.pooh.myHomePage.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.pooh.myHomePage.board.service.FreeCommentService;
import co.pooh.myHomePage.board.serviceImpl.FreeCommentServiceImpl;
import co.pooh.myHomePage.board.vo.FreeCommentVO;
import co.pooh.myHomePage.common.Command;

public class FreeCommentDelete implements Command {

   @Override
   public String execute(HttpServletRequest request, HttpServletResponse response) {
      FreeCommentService dao = new FreeCommentServiceImpl();
      FreeCommentVO vo = new FreeCommentVO();
      vo.setFreeCno(Integer.valueOf(request.getParameter("freecno")));
      vo.setFreeNO(Integer.valueOf(request.getParameter("freeno")));
      System.out.println(request.getParameter("freecno"));
      System.out.println(request.getParameter("freeno"));
      dao.freeBoardDelete(vo);
      
      request.setAttribute("freeno", (Object) vo.getFreeNO());
      
      return "freeBoardSelectcd.do";
   }

}