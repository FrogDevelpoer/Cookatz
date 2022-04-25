package cookatz.product.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;

import cookatz.common.controller.SuperClass;
import cookatz.product.bean.Product;
import cookatz.product.dao.ProductDao;

public class ProductInsertController extends SuperClass {
	ProductDao pdao = null;
	Product bean = null;

	public ProductInsertController() {
		this.pdao = new ProductDao();
		this.bean = new Product();
	}

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super.doProcess(request, response);

		String gotopage = "/product/prInsertForm.jsp";
		super.GotoPage(gotopage);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super.doProcess(request, response);

		MultipartRequest mr = (MultipartRequest) request.getAttribute("mr");
	
		// 1. 파라미터를 챙깁니다.
		String name = mr.getParameter("name");
		String category = mr.getParameter("category");
		int price = Integer.parseInt(mr.getParameter("price"));
		String content = mr.getParameter("content");
		int stock = Integer.parseInt(mr.getParameter("stock"));
		String pdate = mr.getParameter("pdate");
		String remark = mr.getParameter("remark");
		
		String img = mr.getFilesystemName("img");
		
		// 2. bean 객체에 셋팅합니다.
		//this.bean.setNum(num);
		this.bean.setName(name);
		this.bean.setCategory(category);
		this.bean.setPrice(price);
		this.bean.setContent(content);
		this.bean.setStock(stock);
		//this.bean.setPdate(pdate);
		this.bean.setImg(img);
		this.bean.setRemark("");
		
		System.out.println(this.getClass() + " doPost()");
		System.out.println(bean);

		pdao.InsertData(bean);

		new ProductListController().doGet(request, response);
	}
}
