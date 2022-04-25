package cookatz.utility;

import java.io.FileInputStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import javax.servlet.http.HttpServletRequest;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import cookatz.common.controller.SuperController;


public class MyUtility {

	//Map 데이터 타입인 getTodoList() 메소드 , 매개변수는 configFilePath (todoList의 경로)
	public static Map<String, SuperController> getTodoList(String configFilePath) {
		Map<String, SuperController> todolists = null ;
		todolists = new HashMap<String, SuperController>(); 
		
		Properties prop = new Properties() ;
		FileInputStream fis = null ;
		
		try {
			fis = new FileInputStream(configFilePath) ; //todolists 파일을 불러온 fis 객체
			prop.load(fis); //key와 value 값이 String으로 변경
			
		} catch (Exception e) {
			e.printStackTrace(); 
		} finally {
			try {
				if(fis != null) {fis.close();}	
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
		// 현재 prop에는 <String, String> 형태로 데이터가 들어 있습니다.
		// 아래 코드는 이것을 <String, SuperController> 형태로 바꿔 줍니다.
		
		Enumeration<Object> enu = prop.keys() ; //key() 메소드는 key 값을 반환하는데, String이지만, Object로 작성
		while(enu.hasMoreElements()) {
			//command : prop의 key를 문자열로 가지고 있습니다. 
			String command = enu.nextElement().toString() ;
			String className = prop.getProperty(command) ; //todolist의 value값
			
			try {
				Class<?> handleClass = Class.forName(className) ;  //forName() : todolist의 value값 '문자열'을 '클래스'로 만들어주는 메소드
				
				//SuperController의 인스턴스(객체) 생성하여 handclss를 넣고
				SuperController handleInstance 
				 = (SuperController)handleClass.newInstance() ;
				
				//conmmand = key , value= handleInstance 의 객체들이 들어있다.
				todolists.put(command, handleInstance) ;
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return todolists ; //command와 인스턴스(객체)들이 들어있다..
	}

	public static MultipartRequest getMultipartRequest(HttpServletRequest request, String realPath) {
		// 파일 업로드를 위한 mr 객체를 만들어 줍니다.
		MultipartRequest mr = null ;
		int maxPostSize = 10 * 1024 * 1024 ;
		try {
			mr = new MultipartRequest(
					request, 
					realPath, 
					maxPostSize,
					"UTF-8",
					new DefaultFileRenamePolicy()); 
		} catch (Exception e) {
			e.printStackTrace(); 
		}
		
		return mr ;
	}
}