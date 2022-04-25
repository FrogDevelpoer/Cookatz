package cookatz.employee.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cookatz.common.controller.SuperClass;
import cookatz.employee.bean.Employee;
import cookatz.employee.dao.EmployeeDao;

public class EmployeeListController extends SuperClass  {
	EmployeeDao mdao = null;
	Employee bean = null;
	
	public EmployeeListController() {
		this.mdao = new EmployeeDao();
		this.bean = new Employee();
	}
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super.doProcess(request, response); 
		
		//회원 전체 목록을 조회후 lists 담기
		List<Employee> lists = this.mdao.SelectAll();
		System.out.println("회원 목록 수 : " + lists.size());
		
		//request에 바인딩하기
		request.setAttribute("lists", lists);
		
		String gotopage ="/employee/emList.jsp";
		super.GotoPage(gotopage);
		
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
