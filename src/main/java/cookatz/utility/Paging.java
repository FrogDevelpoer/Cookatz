package cookatz.utility;

// 페이징 처리를 위한 페이징 클래스
public class Paging {
	// 페이징 관련 변수
	private int totalCount = 0 ; // 총 레코드(행) 수
	private int totalPage = 0 ; // 전체 페이지 수
	
	private int pageNumber = 0 ; // 현재 페이지 번호
	private int pageSize = 0 ; // 한 페이지에 보여줄 행수
	private int beginRow = 0 ; // 현재 페이지의 시작 랭킹 
	private int endRow = 0 ; // 현재 페이지의 종료 랭킹 
	
	private int pageCount = 10 ; // 하단에 보여지는 페이지 링크 개수(기본 값 : 10)
	private int beginPage = 0 ; // 하단 페이징 처리 시작 페이지 번호
	private int endPage = 0 ; // 하단 페이징 처리 종료 페이지 번호
	
	private String url = "" ; // 이동할 url
	private String pagingStatus = "" ; // 상단 우측의 현재 페이지 상태 정보 
	private String pagingHtml = "" ; // 하단에 보여질 페이지 링크 정보
	
	// 필드 검색을 위한 변수
	private String mode = "" ; // 검색 모드(예시 : 작성자, 글제목, 전체 검색 등등)
	private String keyword = "" ; // 검색할 키워드	
	
	private String paginationSize = "pagination-sm"; // pagination-lg / pagination-sm / pagination-xs
	
	public Paging() {
	
	}
	
	public Paging(String _pageNumber, String _pageSize, int totalCount, String url, String mode, String keyword) {
		
		if(_pageNumber == null || _pageNumber.equals("null") || _pageNumber.equals("")) {
			_pageNumber = "1" ; // 기본 값은 1
		}
		this.pageNumber = Integer.parseInt(_pageNumber) ;
		
		if(_pageSize == null || _pageSize.equals("null") || _pageSize.equals("")) {
			_pageSize = "10" ; // 기본 값은 10
		}
		this.pageSize = Integer.parseInt(_pageSize) ;
		
		this.totalCount = totalCount ;
		
		this.totalPage = (int)Math.ceil(1.0*totalCount/pageSize) ;
		
		this.beginRow = (this.pageNumber - 1) * this.pageSize + 1 ;
		this.endRow = this.pageNumber * this.pageSize ;
		
		this.beginPage = (this.pageNumber - 1) / pageCount * pageCount + 1  ;
		this.endPage = this.beginPage + pageCount - 1  ;
		
		if(endPage > totalPage) {
			endPage = totalPage;
		}
		
		this.url = url ;
		this.mode = mode ; 
		this.keyword = keyword ; 
		
		this.pagingHtml = this.getPagingHtml(url) ;
		this.pagingStatus = "총 " + totalCount + "건[" 
							+ this.pageNumber + "/" + this.totalPage + "]" ;
	}
	
	public int getPageNumber() {
		return pageNumber;
	}
	public int getPageSize() {
		return pageSize;
	}
	public int getBeginRow() {
		return beginRow;
	}
	public int getEndRow() {
		return endRow;
	}
	public String getPagingStatus() {
		return pagingStatus;
	}
	public String getPagingHtml() {
		return pagingHtml;
	}
	public String getMode() {
		return mode;
	}
	public String getKeyword() {
		return keyword;
	}


	private String getPagingHtml( String url ){ //페이징 문자열을 만듭니다.
		String result = "" ;
		
		//add_param 변수 : 검색 관련하여 추가되는 파라미터 리스트
		String add_param = "&mode=" + mode + "&keyword=" + keyword ; 
		
		result += "<ul class='pagination " + paginationSize + "'>";
		if ( pageNumber <= pageCount ) {//1부터 10페이지까지는 [맨처음]과 [이전]이 없다 
			//result += "맨처음&nbsp;&nbsp;";
			//result += "이전&nbsp;&nbsp;";			
		} else {
			result += "<li><a href='" + url + "&pageNumber=" + 1 + 
				"&pageSize=" + pageSize + add_param + "'>맨처음</a></li>&nbsp;&nbsp;";
			
			result += "<li><a href='" + url + "&pageNumber=" + (beginPage - 1) + 
				"&pageSize=" + pageSize + add_param + "'>이전</a></li>&nbsp;&nbsp;";
		}		
		//페이지 시작 번호 부터 ~ 끝 번호 까지 표시

		for (int i = beginPage ; i <= endPage ; i++) {
			if(i == pageNumber){ //현재 페이지이면 링크는 없고, 빨간색으로 표시
				result += "<li class='active'><a><font color='red'><b>" + i + "</b></font></a></li>&nbsp;";
			}else{
				result += "<li><a href='" + url + "&pageNumber=" + i + 
					"&pageSize=" + pageSize + add_param + "'>" + i + "</a></li>&nbsp;";	
			}			
		}
		
		//마지막에는 [다음]과 [맨끝]이 없다
		if ( pageNumber >= (totalPage / pageCount * pageCount + 1) ) {
			//result += "다음&nbsp;&nbsp;";
			//result += "맨 끝&nbsp;&nbsp;";	
		} else {			
			result += "<li><a href='" + url + "&pageNumber=" + (endPage + 1) + 
				"&pageSize=" + pageSize + add_param + "'>다음</a></li>&nbsp;&nbsp;";
			
			result += "<li><a href='" + url + "&pageNumber=" + totalPage + 
				"&pageSize=" + pageSize + add_param + "'>맨 끝</a></li>";
		}
		result += "</ul>"; 
		return result ;
	}

	@Override
	public String toString() {
		System.out.println("totalCount : " + totalCount);
		System.out.println("totalPage : " + totalPage);
		System.out.println("pageNumber : " + pageNumber);
		System.out.println("pageSize : " + pageSize);
		System.out.println("beginRow : " + beginRow);
		System.out.println("endRow : " + endRow);
		System.out.println("pageCount : " + pageCount);
		System.out.println("beginPage : " + beginPage);
		System.out.println("endPage : " + endPage);
		System.out.println("url : " + url);
		System.out.println("pagingStatus : " + pagingStatus);
		System.out.println("pagingHtml : " + pagingHtml);
		System.out.println("mode : " + mode);
		System.out.println("keyword : " + keyword);
		
		return "";
	}

}