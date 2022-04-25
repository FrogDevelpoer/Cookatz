package cookatz.recipe.bean;

public class Recipe {	
	private int seq;	// 글 번호
	private String writer_id; // 작성자 아이디
	private String writer_name; // 작성자 이름
	private String recipe_title; // 레시피 이름
	private String cook_Info; // 요리 소개
	private String write_date;	// 작성일자
	private String cook_step; 	// 요리 단계
	private String main_photo;	// 대표 사진
	private String category; // 카테고리
	private String difficulty;	// 난이도
	private String material1;	// 재료 이름1
	private String material1_1;	// 재료 양1
	private String material2;	// 재료 이름2
	private String material2_1;	// 재료 양2
	private String material3;	// 재료 이름3
	private String material3_1;	// 재료 양3
	private String remark;
	
	@Override
	public String toString() {
		return "Recipe [seq=" + seq + ", writer_id=" + writer_id + ", writer_name=" + writer_name + ", recipe_title="
				+ recipe_title + ", cook_Info=" + cook_Info + ", write_date=" + write_date + ", cook_step=" + cook_step
				+ ", main_photo=" + main_photo + ", category=" + category + ", difficulty=" + difficulty
				+ ", material1=" + material1 + ", material1_1=" + material1_1 + ", material2=" + material2
				+ ", material2_1=" + material2_1 + ", material3=" + material3 + ", material3_1=" + material3_1
				+ ", remark=" + remark + "]";
	}
	public int getSeq() {
		return seq;
	}
	public void setSeq(int seq) {
		this.seq = seq;
	}
	public String getWriter_id() {
		return writer_id;
	}
	public void setWriter_id(String writer_id) {
		this.writer_id = writer_id;
	}
	public String getWriter_name() {
		return writer_name;
	}
	public void setWriter_name(String writer_name) {
		this.writer_name = writer_name;
	}
	public String getRecipe_title() {
		return recipe_title;
	}
	public void setRecipe_title(String recipe_title) {
		this.recipe_title = recipe_title;
	}
	public String getCook_Info() {
		return cook_Info;
	}
	public void setCook_Info(String cook_Info) {
		this.cook_Info = cook_Info;
	}
	public String getWrite_date() {
		return write_date;
	}
	public void setWrite_date(String write_date) {
		this.write_date = write_date;
	}
	public String getCook_step() {
		return cook_step;
	}
	public void setCook_step(String cook_step) {
		this.cook_step = cook_step;
	}
	public String getMain_photo() {
		return main_photo;
	}
	public void setMain_photo(String main_photo) {
		this.main_photo = main_photo;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getDifficulty() {
		return difficulty;
	}
	public void setDifficulty(String difficulty) {
		this.difficulty = difficulty;
	}
	public String getMaterial1() {
		return material1;
	}
	public void setMaterial1(String material1) {
		this.material1 = material1;
	}
	public String getMaterial1_1() {
		return material1_1;
	}
	public void setMaterial1_1(String material1_1) {
		this.material1_1 = material1_1;
	}
	public String getMaterial2() {
		return material2;
	}
	public void setMaterial2(String material2) {
		this.material2 = material2;
	}
	public String getMaterial2_1() {
		return material2_1;
	}
	public void setMaterial2_1(String material2_1) {
		this.material2_1 = material2_1;
	}
	public String getMaterial3() {
		return material3;
	}
	public void setMaterial3(String material3) {
		this.material3 = material3;
	}
	public String getMaterial3_1() {
		return material3_1;
	}
	public void setMaterial3_1(String material3_1) {
		this.material3_1 = material3_1;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
}
