package cookatz.CCBoard.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cookatz.CCBoard.bean.Board;
import cookatz.CCBoard.dao.BoardDao;
import cookatz.common.controller.SuperClass;

public class BoardDetailController extends SuperClass{
	BoardDao bdao = null;
	Board bean = null;
	
	public BoardDetailController() {
		this.bdao = new BoardDao();
		this.bean = new Board();
	}
			
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super.doProcess(request, response);
		
		int bo_no = Integer.parseInt(request.getParameter("bo_no"));

		this.bean = this.bdao.SelectOne(bo_no);
		
		request.setAttribute("bean", this.bean);
		
		String gotopage = "/CCBoard/boDetail.jsp";
		super.GotoPage(gotopage);
	}
}
