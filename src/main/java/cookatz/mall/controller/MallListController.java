package cookatz.mall.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cookatz.common.controller.SuperClass;
import cookatz.mall.cart.CocazShoppingInfo;
import cookatz.mall.dao.MallDao;
import cookatz.product.bean.Product;
import cookatz.product.dao.ProductDao;

public class MallListController extends SuperClass {
	MallDao madao = null;
	ProductDao pdao = null;

	public MallListController() {
		this.madao = new MallDao();
		this.pdao = new ProductDao();
	}

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super.doProcess(request, response);

		// cartItems(상품 번호, 구매 수량) : 구매자가 카트에 담은 모든 상품 목록
		Map<Integer, Integer> cartItems = super.cocazcart.GetAllOrderList();
		System.out.println("구매할 상품 개수 : " + cartItems.size());
		
		//
		/*
		 * int cartsize = cartItems.size(); request.setAttribute("cartsize", cartsize);
		 * System.out.println("카트에 몇개 ?"+cartItems.size());
		 */
		//
		
		List<CocazShoppingInfo> shopList = new ArrayList<CocazShoppingInfo>();

		int totalAmount = 0; // 총 계산 금액

		// cartItems 개수만큼 반복하여
		Set<Integer> keylist = cartItems.keySet();
		for (Integer pnum : keylist) {
			Integer qty = cartItems.get(pnum); // 수량
			Product bean = this.pdao.SelectOne(pnum); // 상품 bean 객체
				
			// CocazShoppingInfo 객체에 데이터를 저장합니다.
			CocazShoppingInfo shopinfo = new CocazShoppingInfo();
			shopinfo.setPnum(bean.getNum());
			shopinfo.setPname(bean.getName());
			shopinfo.setQty(qty);
			shopinfo.setPrice(bean.getPrice());
			shopinfo.setImg(bean.getImg());

			// shopList 컬렉션에 CocazShoppingInfo 객체를 담아 둡니다.
			shopList.add(shopinfo);
			
			System.out.println("쇼핑 정보 불러오기" + shopinfo);
			totalAmount += bean.getPrice() * qty;
			
		}

		
		// shopList 컬렉션을 session 영역에 바인딩합니다.
		super.session.setAttribute("shopList", shopList);
		
		
		// 총 금액과 총 적립 포인트 금액도 session 영역에 바인딩합니다.
		super.session.setAttribute("totalAmount", totalAmount);

		// 목록 보기 페이지로 이동합니다.
		String gotopage = "/cart/CartList.jsp";
		super.GotoPage(gotopage);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super.doProcess(request, response);

		 String id = request.getParameter("id");
		 int salary = Integer.parseInt(request.getParameter("salary"));

		request.setAttribute("ddd", null);
		super.session.setAttribute("ddd", null);

		// 로그인 성공이라고 가정하고

	}
}
