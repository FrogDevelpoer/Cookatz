package cookatz.mall.cart;

import java.util.HashMap;
import java.util.Map;

public class CocazCartList {
	// 카트 내에 담긴 물건들의 목록을 저장하고 있는 Map 컬렉션 
	// key는 상품 번호, value는 카트에 담긴 수량
	private Map<Integer, Integer> orderlists = null ;
	
	public CocazCartList() {
		this.orderlists = new HashMap<Integer, Integer>() ;
	}
	
	// 장바구니에 물건을 담습니다.(pnum는 상품 번호, qty는 구매 수량)
	// 해당 상품이 이미 담겨 있으면 누적시키고, 없으면 그냥 추가하면 됩니다.
	public void AddOrder(int pnum, int qty) {
		
//		if (this.orderlists.containsKey(pnum)) {
//			int prev = this.orderlists.get(pnum) ;
//			this.orderlists.put(pnum, prev + qty) ;
//			
//		}else {
			this.orderlists.put(pnum, qty) ;
//		}
	}
	
	// 장바구니에 이미 들어간 물건을 몇개 덜어 냅니다.
	public void EditOrder(int pnum, int qty) {
		this.AddOrder(pnum, qty); 
	}
	
	// 담았던 물건을 뺍니다.(구매 안하기로 했슴)
	public void DeleteOrder(int pnum) {
		this.orderlists.remove(pnum) ;
	}
	
	// 모든 상품 내역을 확인합니다.(계산시 영수증 형태로 확인)
	public Map<Integer, Integer> GetAllOrderList(){
		return this.orderlists ;
	}
	
	// 모든 상품 내역을 비웁니다.
	public void RemoveAllProduct() {
		this.orderlists.clear(); 
	}	
}
