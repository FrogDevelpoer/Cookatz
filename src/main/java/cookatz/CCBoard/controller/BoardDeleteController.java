package cookatz.CCBoard.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cookatz.CCBoard.dao.BoardDao;
import cookatz.common.controller.SuperClass;

public class BoardDeleteController extends SuperClass{
	BoardDao bdao = null;
	
	public BoardDeleteController() {
		this.bdao = new BoardDao();
	}
			
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super.doProcess(request, response);
		
		int bo_no = Integer.parseInt(request.getParameter("bo_no"));
		this.bdao.DeleteData(bo_no);
		
		String message = "영상이 삭제되었습니다.";
		super.setErrorMessage(message);
		
		new BoardListController().doGet(request, response);
	}
}
