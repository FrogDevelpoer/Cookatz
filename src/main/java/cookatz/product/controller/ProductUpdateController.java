package cookatz.product.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;

import cookatz.common.controller.SuperClass;
import cookatz.product.bean.Product;
import cookatz.product.dao.ProductDao;

public class ProductUpdateController extends SuperClass {
	ProductDao pdao = null;
	Product bean = null;

	public ProductUpdateController() {
		this.pdao = new ProductDao();
		this.bean = new Product();
	}

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super.doProcess(request, response);
		int num = Integer.parseInt(request.getParameter("num"));
		this.bean = this.pdao.SelectOne(num);

		request.setAttribute("bean", bean);

		String gotopage = "/product/prUpdateForm.jsp";
		super.GotoPage(gotopage);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super.doProcess(request, response);

		MultipartRequest mr = (MultipartRequest) request.getAttribute("mr");

		// 1. 파라미터를 챙깁니다.
		int num = Integer.parseInt(mr.getParameter("num")) ;
		String name = mr.getParameter("name");
		String category = mr.getParameter("category");
		int price = Integer.parseInt(mr.getParameter("price"));
		String content = mr.getParameter("content");
		int stock = Integer.parseInt(mr.getParameter("stock"));
		String pdate = mr.getParameter("pdate");
		String company = mr.getParameter("remark");
		
		String img = mr.getFilesystemName("img") ;

		// 2. bean 객체에 셋팅합니다.
		this.bean.setNum(num); // 기본 키가 넘어와야함.
		this.bean.setName(name);
		this.bean.setCategory(category);
		this.bean.setPrice(price);
		this.bean.setContent(content);
		this.bean.setImg(img);
		this.bean.setPdate(pdate);
		this.bean.setRemark(company);
		this.bean.setStock(stock);

		System.out.println(this.getClass() + " doPost()");
		System.out.println(bean);

		// dao를 이용하여 데이터 베이스에 수정합니다.
		pdao.UpdateData(bean);

		// 상품 목록 페이지로 이동합니다.
		new ProductListController().doGet(request, response);
	}
}
