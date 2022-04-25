package cookatz.recipe.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cookatz.common.controller.SuperClass;
import cookatz.recipe.bean.Recipe;
import cookatz.recipe.dao.RecipeDao;

public class RecipeDeleteController extends SuperClass{
	
	RecipeDao rdao = null;
	Recipe bean = null;
	
	public RecipeDeleteController() {
		this.rdao = new RecipeDao();
		this.bean = new Recipe();
		
	}
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) {
		super.doProcess(request, response);
		
		int seq = Integer.parseInt(request.getParameter("seq"));
		this.rdao.DeleteData(seq);
		
		String message = "레시피가 삭제되었습니다.";
		super.setErrorMessage(message);
		
		new RecipeListController().doGet(request, response);
	}
}
