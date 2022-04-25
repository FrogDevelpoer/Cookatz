package cookatz.product.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cookatz.common.controller.SuperClass;
import cookatz.product.bean.Product;
import cookatz.product.dao.ProductDao;

public class ProductListController extends SuperClass {
	ProductDao pdao = null ;
	Product bean = null;
	
	public ProductListController() {
		this.pdao = new ProductDao() ;
		this.bean = new Product();
	}
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super.doProcess(request, response);
		
		String category = "veg";
		System.out.println("category1 : " + category);
		
		List<Product> lists = this.pdao.SelectAll(category) ;
		System.out.println(lists);
		System.out.println("상품 갯수 : " + lists.size());
		request.setAttribute("lists", lists);
		
		int cnt =lists.size();
		System.out.println("몇이니?"+cnt);
		
		request.setAttribute("cnt", cnt);
		
		request.setAttribute("lists", lists);
		request.setAttribute("category", category);
		
		
		String gotopage = "/product/prVegList.jsp";
		super.GotoPage(gotopage);
	}	 
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super.doProcess(request, response);
		System.out.println("category1 : " + request.getParameter("category"));
		
		List<Product> lists = this.pdao.SelectAll(request.getParameter("category"));
		
		System.out.println(request.getParameter("category") + "상품 갯수 : " + lists.size());
		System.out.println("상품 갯수 : " + lists.size());
		
		request.setAttribute("lists", lists);
		request.setAttribute("category", request.getParameter("category"));
		
		String gotopage = "/product/prVegList.jsp";
		super.GotoPage(gotopage);	
		
	}	 
}