package cookatz.employee.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cookatz.common.controller.SuperClass;
import cookatz.employee.bean.Employee;
import cookatz.employee.dao.EmployeeDao;

public class EmployeeDeleteController extends SuperClass  {
	EmployeeDao mdao = null;
	
	public EmployeeDeleteController() {
		this.mdao = new EmployeeDao();
		
	}
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super.doProcess(request, response); 
		
		String id = request.getParameter("id");
		this.mdao.DeleteData(id);
		
		//현 회원이 사용하던 세션 정보를 클리어 해줍니다.
		super.session.invalidate();
		
		String message ="탈퇴 되었습니다. 안녕히 가세요"; 
		super.setErrorMessage(message);
		
		
	
		//로그인 페이지로 이동
		new EmployeeLoginController().doGet(request, response);
	}


}
