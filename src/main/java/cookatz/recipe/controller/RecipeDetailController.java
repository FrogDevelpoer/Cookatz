package cookatz.recipe.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cookatz.common.controller.SuperClass;
import cookatz.recipe.bean.Recipe;
import cookatz.recipe.dao.RecipeDao;

public class RecipeDetailController extends SuperClass{
	RecipeDao rdao = null;
	Recipe bean = null;
	
	public RecipeDetailController() {
		this.rdao = new RecipeDao();
		this.bean = new Recipe();
	}
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) {
		super.doProcess(request, response);
		
		int seq = Integer.parseInt(request.getParameter("seq"));
		this.bean = this.rdao.SelectOne(seq);
		
		request.setAttribute("bean", this.bean);
		
		System.out.println(bean);
		
		String gotopage = "/recipe/reDetail.jsp";
		super.GotoPage(gotopage);
	}
}
