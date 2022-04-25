package cookatz.mall.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cookatz.common.controller.SuperClass;
import cookatz.mall.dao.MallDao;
import cookatz.product.bean.Product;
import cookatz.product.dao.ProductDao;

public class MallUpdateController extends SuperClass {
	MallDao madao = null;
	ProductDao pdao = null;

	public MallUpdateController() {
		this.madao = new MallDao();
		this.pdao = new ProductDao();
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super.doProcess(request, response);

		// 해당 상품 번호에 대하여 수량(qty)로 개수를 변경합니다.
		int pnum = Integer.parseInt(request.getParameter("pnum"));
		int qty = Integer.parseInt(request.getParameter("qty"));

		Product bean = this.pdao.SelectOne(pnum);

		if (qty > bean.getStock()) { // 재고 수량 부족
			String message = "재고 수량이 부족합니다.";
			super.setErrorMessage(message);
			new MallListController().doGet(request, response);

		} else {
			super.cocazcart.EditOrder(pnum, qty);
			// 다시 session 영역에 바인딩해줍니다.
			super.session.setAttribute("cocazcart", cocazcart);
			new MallListController().doGet(request, response);
		}
	}
}