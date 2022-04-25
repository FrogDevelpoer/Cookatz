package cookatz.recipe.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cookatz.common.controller.SuperClass;
import cookatz.recipe.bean.Recipe;
import cookatz.recipe.dao.RecipeDao;
import cookatz.utility.FlowParameters;
import cookatz.utility.Paging;

public class RecipeListController extends SuperClass{
	
	RecipeDao rdao = null;
	
	public RecipeListController() {
		this.rdao = new RecipeDao();
	}
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) {
		super.doProcess(request, response);
		
		FlowParameters parameters 
			= new FlowParameters(
					request.getParameter("pageNumber"),
					request.getParameter("pageSize"),
					request.getParameter("mode"),
					request.getParameter("keyword"));
		
		System.out.println(this.getClass() + " : " + parameters.toString());
		
		int totalCount 
			= this.rdao.GetTotalCount(
					parameters.getMode(),
					parameters.getKeyword());
		
		String url = super.getUrl("reList");
		
		Paging pageInfo
			= new Paging(
				parameters.getPageNumber(),
				parameters.getPageSize(),
				totalCount,
				url,
				parameters.getMode(),
				parameters.getKeyword());
		
		List<Recipe> lists 
		= this.rdao.PagingInfo(
				pageInfo.getBeginRow(), 
				pageInfo.getEndRow(),
				parameters.getMode(), 
				parameters.getKeyword()) ;
			
		
		System.out.println("레시피 개수 : " + lists.size());
		
		request.setAttribute("lists", lists);
		
		request.setAttribute("pageInfo", pageInfo);
		
		request.setAttribute("parameters", parameters);
		
		String gotopage = "/recipe/reList.jsp";
		super.GotoPage(gotopage);
		
	}
	
	
}
