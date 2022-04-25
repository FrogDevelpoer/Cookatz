package cookatz.mall.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cookatz.common.controller.SuperClass;
import cookatz.mall.dao.MallDao;
import cookatz.product.controller.ProductDetailController;

public class MallInsertController extends SuperClass {
	MallDao madao = null;
	//Mall bean = null ;
	

	public MallInsertController() {
		this.madao = new MallDao();
		//this.bean = new Mall() ; 
	}

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super.doProcess(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super.doProcess(request, response);

		String gotopage = "";

		if (super.loginfo == null) {
			gotopage = "/employee/login.jsp";
			super.GotoPage(gotopage);

		} else {
			int num = Integer.parseInt(request.getParameter("num")); // 상품 번호
			int stock = Integer.parseInt(request.getParameter("stock")); // 재고 수량
			int qty = Integer.parseInt(request.getParameter("qty")); // 주문 수량

			if (qty <= 0) { // 주문 수량이 재고 수량 초과
				String message = "잘못된 값을 입력하셨습니다.";
				super.setErrorMessage(message);
				new ProductDetailController().doGet(request, response);

			}else if (stock < qty) {
				String message = "재고 수량이 부족합니다.";
				super.setErrorMessage(message);
				new ProductDetailController().doGet(request, response);

			}else { // 주문 가능
				super.cocazcart.AddOrder(num, qty);
				super.session.setAttribute("cocazcart", super.cocazcart);
				new MallListController().doGet(request, response);
				
			}
			
		}
	}
}
