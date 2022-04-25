package cookatz.employee.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cookatz.common.controller.SuperClass;
import cookatz.employee.bean.Employee;
import cookatz.employee.dao.EmployeeDao;

public class TempleteController extends SuperClass  {
	EmployeeDao mdao = null;
	Employee bean = null;
	
	public TempleteController() {
		this.mdao = new EmployeeDao();
		this.bean = new Employee();
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
		String gotopage ="/member/meList.jsp";
		super.GotoPage(gotopage);
	}

}
