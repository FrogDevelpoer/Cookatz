package cookatz.employee.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cookatz.common.controller.SuperClass;
import cookatz.employee.bean.Employee;
import cookatz.employee.dao.EmployeeDao;
import cookatz.common.controller.MainController;

public class EmployeeUpdateController extends SuperClass  {
	EmployeeDao mdao = null;
	Employee bean = null;
	
	public EmployeeUpdateController() {
		this.mdao = new EmployeeDao();
		this.bean = new Employee();
	}
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super.doProcess(request, response); 
		
		//회원정보수정
		
		//pk로 dao에서 회원 정보를 조회하고 
		String id = request.getParameter("id");
		this.bean = mdao.SelectOne(id);
		
		System.out.println("bean값은 : "+this.bean);
		
		//해당 회원의 정보를 '수정 form'에서 보여주기 위해 request에 바인딩
		request.setAttribute("bean", this.bean);
		
		//회원 수정 form으로 이동
		String gotopage ="/employee/Update.jsp";
		super.GotoPage(gotopage);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super.doProcess(request, response);
		
		//파라미터 챙기기
		String id = request.getParameter("id");
		String password = request.getParameter("nowpassword");
		//String newpassword = request.getParameter("newpassword");
		//String checkpassword = request.getParameter("checkpassword");
		
		String name = request.getParameter("name");
		String birth1 = request.getParameter("birth1");
		String birth2 = request.getParameter("birth2");
		String birth3 = request.getParameter("birth3");
		String gender = request.getParameter("gender");
		String phone = request.getParameter("phone");
		String email = request.getParameter("email");
		
		//int zipcode = Integer.parseInt(request.getParameter("zipcode"));
		//String address1 = request.getParameter("address1");
		//String address2 = request.getParameter("address2");
		//int mpoint = Integer.parseInt(request.getParameter("mpoint"));
		
		
		//bean에 셋팅
		this.bean.setId(id);
		this.bean.setPassword(password);
		
		//if(bean.getPassword() == nowpassword && checkpassword!=newpassword) {
			//this.bean.setPassword(newpassword);
			
		//}
		
		
		this.bean.setName(name);
		this.bean.setBirth1(birth1);
		this.bean.setBirth2(birth2);
		this.bean.setBirth3(birth3);
		this.bean.setGender(gender);
		this.bean.setPhone(phone);
		this.bean.setEmail(email);
		//this.bean.setZipcode(0);
		//this.bean.setAddress1(email);
		//this.bean.setAddress2(email);
		//this.bean.setMpoint(0);
		
		System.out.println("bean이 모고:"+this.bean);
		
		//db에 수정
		mdao.UpdateData(bean);
		
		//request.setAttribute("bean", this.bean);
		
		//회원정보 수정 후 메인 이동
		String message = "회원정보가 수정되었습니다.";
		super.session.setAttribute("message", message);
		new MainController().doGet(request, response);
		
		
	
	}

}
