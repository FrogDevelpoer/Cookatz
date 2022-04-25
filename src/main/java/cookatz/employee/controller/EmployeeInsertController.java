package cookatz.employee.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.dbcp.dbcp2.PStmtKey;

import cookatz.common.controller.SuperClass;
import cookatz.employee.bean.Employee;
import cookatz.employee.dao.EmployeeDao;

public class EmployeeInsertController extends SuperClass  {
	EmployeeDao mdao = null;
	Employee bean = null;
	
	public EmployeeInsertController() {
		this.mdao = new EmployeeDao();
		this.bean = new Employee();
	}
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super.doProcess(request, response); 
		
		// 회원가입 눌렀을 때 회원가입 페이지로 이동
		String gotopage ="/employee/Insert.jsp";
		super.GotoPage(gotopage);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super.doProcess(request, response);
		
		//파라미터 챙기기
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		String name = request.getParameter("name");
		String birth1 = request.getParameter("birth1");
		String birth2 = request.getParameter("birth2");
		String birth3 = request.getParameter("birth3");
		String gender = request.getParameter("gender");
		String phone = request.getParameter("phone");
		String email = request.getParameter("email");
		int zipcode = Integer.parseInt(request.getParameter("zipcode"));
		String address1 = request.getParameter("address1");
		String address2 = request.getParameter("address2");
		
		//int mpoint = Integer.parseInt(request.getParameter("mpoint"));
		
		//bean에 셋팅하기
		bean.setAddress1(address1);
		bean.setAddress2(address2);
		bean.setZipcode(zipcode);
		bean.setBirth1(birth1);
		bean.setBirth2(birth2);
		bean.setBirth3(birth3);
		bean.setEmail(email);
		bean.setGender(gender);
		bean.setId(id);
		//bean.setMpoint(mpoint);
		bean.setName(name);
		bean.setPassword(password);
		bean.setPhone(phone);
		
		System.out.println(this.getClass()+"doPost()");
		System.out.println(bean);
		
		//data dao에 넣기
		mdao.InsertData(this.bean);
		
		
		// 회원가입 성공 후 로그인 페이지로 이동
		String message ="Welcome! 회원가입을 축하합니다. 로그인을 진행하세요";
		super.session.setAttribute("message", message);
		new EmployeeLoginController().doGet(request, response);
	}

}
