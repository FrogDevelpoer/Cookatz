package cookatz.common.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface SuperController {
	// 추상 메소드 : 실행이 안됨
	//인터페이스는 기능을 명시적으로 선언하는 역할. 일반 메소드와 변수, 객체를 생성할 수 없다.
	public void doGet(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException;
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException;
	//controller에서 동일한 부분은 메소드를 만들어 호출이 가능하나,
		//인터페이스는 추상메소드이고 여기다 만들시, 상속받은 controller에서 메소드를 다 만들어야 하므로 
		//SuperClass하나 만든다.
}

