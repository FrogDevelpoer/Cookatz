package cookatz.product.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cookatz.common.controller.SuperClass;
import cookatz.product.bean.Product;
import cookatz.product.dao.ProductDao;

public class ProductDeleteController extends SuperClass {
	ProductDao pdao = null ;
	
	Product bean = null ;
	
	public ProductDeleteController() {
		this.pdao = new ProductDao() ;
		this.bean = new Product() ; 
	}
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super.doProcess(request, response);
		
		int num = Integer.parseInt(request.getParameter("num")) ;
		String name = request.getParameter("name");
		
		this.pdao.DeleteData(num) ;
		
		String message = name + "이(가) 삭제되었습니다." ;
		
		super.session.setAttribute("message", message);
			
		new ProductListController().doGet(request, response); 
	}
}