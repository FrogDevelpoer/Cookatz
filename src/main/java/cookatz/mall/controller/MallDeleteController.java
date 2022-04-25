package cookatz.mall.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cookatz.common.controller.SuperClass;
import cookatz.mall.dao.MallDao;

public class MallDeleteController extends SuperClass {
	MallDao madao = null;

	public MallDeleteController() {
		this.madao = new MallDao();
	}

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super.doProcess(request, response);

		// 삭제하고자하는 상품 번호에 대하여 session 영역에 있는 cocazcart에서 물건을 제거합니다.
		int pnum = Integer.parseInt(request.getParameter("pnum"));
		super.cocazcart.DeleteOrder(pnum);

		// 다시 session 영역에 바인딩해줍니다.
		super.session.setAttribute("cocazcart", cocazcart);

		new MallListController().doGet(request, response);
	}
}