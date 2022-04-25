package cookatz.CCBoard.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cookatz.common.controller.SuperClass;

public class TemplateController extends SuperClass{
	//MallDao madao = null;
	//Mall bean = null;
	
	public TemplateController() {
		//this.madao = new MallDao();
		//this.bean = new Mall();
	}
			
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super.doProcess(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super.doProcess(request, response);
		
		String id = request.getParameter("id");
		int salary = Integer.parseInt(request.getParameter("salary"));
		
		request.setAttribute("ddd", null);
		super.session.setAttribute("ddd", null);
		
		// 로그인 성공이라고 가정하고
		String gotopage = "/mall/maList.jsp";
		super.GotoPage(gotopage);
	}
}
