package cookatz.common.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;

import cookatz.utility.MyUtility;


@WebServlet(
		urlPatterns = {"/Cookatz"}, 
		initParams = {
				@WebInitParam(name = "configFile", value = "/WEB-INF/todolist.txt")
		})
public class FrontController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	// 서브 컨트롤러들의 모음집
	private Map<String, SuperController> todolists = new HashMap<String, SuperController>() ;
	private ServletContext application = null ;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		this.application = config.getServletContext() ;
		
		String configFile = config.getInitParameter("configFile") ;
		System.out.println("configFile : " + configFile);
		
		String configFilePath = config.getServletContext().getRealPath(configFile) ;
		System.out.println("configFilePath : " + configFilePath);
		
		this.todolists = MyUtility.getTodoList(configFilePath);
		System.out.println("todolists.size() : " + this.todolists.size()); 
	}
	private void doProcess(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String command = request.getParameter("command") ;
		System.out.println(this.getClass() + " command : [" + command + "]");
		
		// realPath : 이미지가 업로드 되는 웹 애플리케이션에 있는 경로
		String realPath = this.application.getRealPath("/upload") ;
		System.out.println("realPath : " + realPath);
		
		// 파일 업로드와 상관 없이 항상 application 스코프에 저장해 두어야 합니다.
		// 상품 상세 보기에서 이미지를 볼수 있어야 하므로
		this.application.setAttribute("realPath", realPath);
		
		if(command==null) {
			System.out.println("file upload event");
			
			MultipartRequest mr = MyUtility.getMultipartRequest(request, realPath) ;
			if(mr != null) {
				command = mr.getParameter("command") ;
				request.setAttribute("mr", mr) ;
				request.setAttribute("realPath", realPath) ;
			}
		}
		
		String method = request.getMethod().toLowerCase() ;
		
		SuperController controller = this.todolists.get(command) ;
		
		if (controller != null) {
			if (method.equals("get")) {
				System.out.println(controller.toString() + " get method called");
				controller.doGet(request, response);
			} else {
				System.out.println(controller.toString() + " post method called");
				controller.doPost(request, response);
			}
		} else {
			System.out.println(command + " is not found");
		}
	}	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doProcess(request, response);	
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doProcess(request, response);
	}
}