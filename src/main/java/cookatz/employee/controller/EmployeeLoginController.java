package cookatz.employee.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cookatz.common.controller.MainController;
import cookatz.common.controller.SuperClass;
import cookatz.employee.bean.Employee;
import cookatz.employee.dao.EmployeeDao;
import cookatz.mall.cart.CocazShoppingInfo;
import cookatz.mall.dao.MallDao;

public class EmployeeLoginController extends SuperClass {
	
	EmployeeDao mdao = new EmployeeDao();
	Employee bean = null;
	MallDao madao = null;
	
	//생성자
	public EmployeeLoginController() {
		this.mdao = new EmployeeDao();
		this.bean = new Employee();
		this.madao = new MallDao();
	}
	
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super.doProcess(request, response); 
		
		// 로그인 성공이라고 가정하고
		String gotopage ="/employee/login.jsp";
		super.GotoPage(gotopage);
	
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super.doProcess(request, response);
		//로그인 
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		
		//아이디 비밀번호가 존재하는지 체크 
		this.bean = this.mdao.LoginCheck(id, password);
		System.out.println("로그인 정보 : "+this.bean);
		
		//아이디 중복체크 
		if(this.bean == null) { //db에 id가 없다면, 로그인 실패
			String message ="로그인 또는 비밀번호가 잘못되었습니다.";
			super.setErrorMessage(message);
			
			//로그인페이지로 이동
			new EmployeeLoginController().doGet(request,response);
			
		}else { //로그인 성공
			super.session.setAttribute("loginfo", this.bean); //세션에 
			
			// 장바구니에 나의 쇼핑 정보가 있으면 session 영역에 바인딩합니다.
			List<CocazShoppingInfo> wishlist = madao.GetCocazShoppingInfo(this.bean.getId());

			if (wishlist.size() > 0) { // 찜 목록이 있으면
				for (CocazShoppingInfo item : wishlist) { // 각 품목을 반복하여 cart에 담기
					super.cocazcart.AddOrder(item.getPnum(), item.getQty());
				}
				super.session.setAttribute("cocazcart", super.cocazcart);
			}
			
			//로그인 성공 메시지
			String message = bean.getName()+"로그인에 성공하셨습니다";
			super.session.setAttribute("message", message);
			//메인페이지로 이동
			new MainController().doGet(request,response);
		}
		
		
	}

}
