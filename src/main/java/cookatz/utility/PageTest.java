package cookatz.utility;

public class PageTest {
	public static void main(String[] args) {
		String pageNumber = "3" ;
		String pageSize = "10" ;
		int totalCount = 62 ;
		String url = "boList.jsp" ;
		String mode = "" ;
		String keyword = "" ;
		
		String imsi = "총 건수가 " + totalCount + "개인 목록에서 \n" ;
		imsi += "한 페이지에 " + pageSize + "개씩 볼건데 \n" ;
		imsi += pageNumber + " 페이지를 보여 주세요" ;
		
		System.out.println(imsi);
		
		Paging pageInfo 
			= new Paging(
					pageNumber, 
					pageSize, 
					totalCount,
					url,
					mode,
					keyword );
		
		System.out.println(pageInfo);
	}
}