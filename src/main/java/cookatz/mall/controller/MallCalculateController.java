package cookatz.mall.controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cookatz.common.controller.MainController;
import cookatz.common.controller.SuperClass;
import cookatz.mall.dao.MallDao;

public class MallCalculateController extends SuperClass {
	MallDao madao = null;

	public MallCalculateController() {
		this.madao = new MallDao();
	}

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super.doProcess(request, response);

		Map<Integer, Integer> cartItems = super.cocazcart.GetAllOrderList();

		// 로그인 한 사람의 장바구니 정보를 넘겨 줍니다.
		this.madao.Calculate(super.loginfo, cartItems);
		
		// loginfo를 제외한 session 영역의 정보들을 제거합니다.
		super.session.removeAttribute("totalAmount");
		super.session.removeAttribute("cocazcart");
		super.session.removeAttribute("shopList");

		new MainController().doGet(request, response);
	}
}