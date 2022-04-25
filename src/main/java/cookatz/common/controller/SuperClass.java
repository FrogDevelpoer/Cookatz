package cookatz.common.controller;


import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cookatz.employee.bean.Employee;
import cookatz.mall.cart.CocazCartList;

public class SuperClass implements SuperController{
	
	private HttpServletRequest request = null;
	private HttpServletResponse response = null;
	//protected 접근지정자 : 
	protected HttpSession session = null; // 세션 객체
	protected Employee loginfo = null; //로그인 여부
	protected CocazCartList cocazcart  = null; //구매자의 카트 객체
	
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

	public void setErrorMessage(String message) {
		// 로그인 실패시 사용됨
		// request영역에 사용자를 위한 통지를 바인딩합니다.
		this.request.setAttribute("errmsg", message); //common.jsp에 에러메시지로 뜨게 된다.
	}
	
	public void doProcess(HttpServletRequest request, HttpServletResponse response) {
		// 서브 클래스에서 호출하여 request, response를 인스턴스 변수에 대입합니다.
		this.request = request;
		this.response = response;
		this.session = request.getSession();
		
		//주의 : 해당 데이터 타입으로 강등 요망
		this.loginfo = (Employee)this.session.getAttribute("loginfo");
		this.cocazcart= (CocazCartList)this.session.getAttribute("cocazcart");
		
		if(this.cocazcart == null) { //장바구니가 준비가 안되었으면..
			this.cocazcart = new CocazCartList();
		}
	}

	public void GotoPage(String gotopage) {
		// 이동할 페이지로 포워딩을 수행합니다.
		RequestDispatcher dispatcher = this.request.getRequestDispatcher(gotopage);
		try {
			dispatcher.forward(this.request, this.response);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public String getUrl(String command) {
		// 이동할 url 문자열을 생성해 줍니다.
		// command는 todolist.txt에 명시된 커맨드 이름
		String result = this.request.getContextPath() + "/Cookatz" + "?command=" + command;
		
		// result 예시) http://localhost:8888/JspStudent/Shopping?command=boList
		
		return result;
	}
}
