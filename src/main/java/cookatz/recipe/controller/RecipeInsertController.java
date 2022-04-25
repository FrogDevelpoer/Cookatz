package cookatz.recipe.controller;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;

import cookatz.common.controller.SuperClass;
import cookatz.recipe.bean.Recipe;
import cookatz.recipe.dao.RecipeDao;

public class RecipeInsertController extends SuperClass{
	RecipeDao rdao = null;
	Recipe bean = null;
	
	public RecipeInsertController() {
		this.rdao = new RecipeDao();
		this.bean = new Recipe();
	}
	@Override 
	public void doGet(HttpServletRequest request, HttpServletResponse response) {
		super.doProcess(request, response);
		
		
		String gotopage = "/recipe/recipeInsertForm.jsp";
		super.GotoPage(gotopage);
	}
	
	
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response)  throws ServletException, IOException {
		super.doProcess(request, response);
		
		MultipartRequest mr = (MultipartRequest)request.getAttribute("mr");
		
		String writer_id = mr.getParameter("writer_id");
		String writer_name = mr.getParameter("writer_name");
		//int seq = Integer.parseInt(mr.getParameter("seq"));
		String recipe_title = mr.getParameter("recipe_title");
		String cook_Info = mr.getParameter("cook_Info");
		String cook_step = mr.getParameter("cook_step");
		
		String main_photo = mr.getFilesystemName("main_photo");
		
		String category = mr.getParameter("category");
		String difficulty = mr.getParameter("difficulty");
		String material1 = mr.getParameter("material1");
		String material1_1 = mr.getParameter("material1_1");
		String material2 = mr.getParameter("material2");
		String material2_1 = mr.getParameter("material2_1");
		String material3 = mr.getParameter("material3");
		String material3_1 = mr.getParameter("material3_1");
		
		this.bean.setWriter_id(writer_id);
		this.bean.setCategory(category);
		this.bean.setCook_Info(cook_Info);
		this.bean.setCook_step(cook_step);
		this.bean.setDifficulty(difficulty);
		this.bean.setMain_photo(main_photo);
		this.bean.setMaterial1(material1);
		this.bean.setMaterial1_1(material1_1);
		this.bean.setMaterial2(material2);
		this.bean.setMaterial2_1(material2_1);
		this.bean.setMaterial3(material3);
		this.bean.setMaterial3_1(material3_1);
		this.bean.setRecipe_title(recipe_title);
		this.bean.setRemark("");
		
		//this.bean.setSeq(0);
		this.bean.setWriter_id(writer_id);
		this.bean.setWriter_name(writer_name);
		
		System.out.println(this.getClass() + " doPost()");
		System.out.println(bean);
		
		rdao.InsertData(bean);
		
		// 새로고침해도 게시물 추가 안되게끔
		String contextPath = request.getContextPath();
		String mapping = "/Cookatz";
		String noForm=contextPath+mapping+"?command=";
		
		String gotopage=noForm+"reList";
		response.sendRedirect(gotopage);
	}
}
