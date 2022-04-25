package cookatz.CCBoard.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cookatz.CCBoard.bean.Board;
import cookatz.CCBoard.dao.BoardDao;
import cookatz.common.controller.SuperClass;

public class BoardMainListController extends SuperClass{
	BoardDao bdao = null;
	
	public BoardMainListController() {
		this.bdao = new BoardDao();
	}
			
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super.doProcess(request, response);
		
		List<Board> lists = this.bdao.SelectAll();
		System.out.println("게시물 건수 : " + lists.size());
		
		request.setAttribute("lists", lists);
		
		String gotopage = "/CCBoard/boMainList.jsp";
		super.GotoPage(gotopage);
	}
}
