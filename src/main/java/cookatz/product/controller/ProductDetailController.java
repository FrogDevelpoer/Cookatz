package cookatz.product.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cookatz.common.controller.SuperClass;
import cookatz.product.bean.Product;
import cookatz.product.dao.ProductDao;

public class ProductDetailController extends SuperClass {
	ProductDao pdao = null;

	Product bean = null;

	public ProductDetailController() {
		this.pdao = new ProductDao();
		this.bean = new Product();
	}

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super.doProcess(request, response);

		int num = Integer.parseInt(request.getParameter("num"));
		this.bean = this.pdao.SelectOne(num);

		request.setAttribute("bean", this.bean);

		String gotopage = "/product/prDetail.jsp";
		super.GotoPage(gotopage);
	}
}