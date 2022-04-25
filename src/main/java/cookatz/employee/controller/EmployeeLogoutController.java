package cookatz.employee.controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cookatz.common.controller.MainController;
import cookatz.common.controller.SuperClass;
import cookatz.employee.bean.Employee;
import cookatz.employee.dao.EmployeeDao;
import cookatz.mall.dao.MallDao;

public class EmployeeLogoutController extends SuperClass {
	
	EmployeeDao mdao = new EmployeeDao();
	Employee bean = null;
	MallDao madao = null;
	
	//생성자
	public EmployeeLogoutController() {
		this.mdao = new EmployeeDao();
		this.bean = new Employee();
		this.madao = new MallDao();
	}
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super.doProcess(request, response); 
		
		
		//만약 session 영역에 장바구니 정보가 들어있으면, 반드시 임시 테이블에 저장해야 합니다.
		if(super.cocazcart != null) { // 찜 리스트가 들어 있으면
			Map<Integer, Integer> wishlist = cocazcart.GetAllOrderList();
			this.madao.InsertCartData(super.loginfo, wishlist);
		}
		
		
		//나의 로그인 정보 및 쇼핑 정보들을 모두 지워줍니다.
		super.session.invalidate();
		//invalidate(): 내 세션에 있는 정보 탈탈 털어버리겠다.
	
		// 로그아웃 하면 메인페이지로
		//메인페이지로 이동
		new MainController().doGet(request,response);
		
		
	}
}


