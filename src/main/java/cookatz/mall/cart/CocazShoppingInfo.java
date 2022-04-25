package cookatz.mall.cart;

// 고객이 주문한 상품 1개에 대한 정보를 담고 있는 장바구니 Bean 클래스
public class CocazShoppingInfo {
	private int pnum; // 상품 번호
	private String pname; // 상품 이름
	private int qty; // 주문 수량
	private int price; // 단가
	private String img; // 상품 이미지 이름
	private String eid; // 상품 이미지 이름
	private String inputdate; // 상품 이미지 이름
	
	public CocazShoppingInfo() {}
	
	@Override
	public String toString() {
		return "CocazShoppingInfo [pnum=" + pnum + ", pname=" + pname + ", qty=" + qty + ", price=" + price + ", img="
				+ img + ", eid=" + eid + ", inputdate=" + inputdate + "]";
	}
	public int getPnum() {
		return pnum;
	}
	public void setPnum(int pnum) {
		this.pnum = pnum;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public String getEid() {
		return eid;
	}
	public void setEid(String eid) {
		this.eid = eid;
	}
	public String getInputdate() {
		return inputdate;
	}
	public void setInputdate(String inputdate) {
		this.inputdate = inputdate;
	}
	
	
}