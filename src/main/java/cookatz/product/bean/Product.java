package cookatz.product.bean;

public class Product {
	private int num; // 상품번호
	private String name; // 상품명
	private String category; // 카테고리
	private int price; //단가
	private String content; // 상품 소개
	private String img; // 이미지
	private int stock; // 재고
	private String pdate; // 입고일자
	private String remark; //비고
	
	@Override
	public String toString() {
		return "product [num=" + num + ", name=" + name + ", category=" + category + ", price=" + price + ", content="
				+ content + ", img=" + img + ", stock=" + stock + ", pdate=" + pdate + ", remark=" + remark
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}
	
	public int getNum() {
		return num;
	}
	
	public void setNum(int num) {
		this.num = num;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public String getPdate() {
		return pdate;
	}
	public void setPdate(String pdate) {
		this.pdate = pdate;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
}
