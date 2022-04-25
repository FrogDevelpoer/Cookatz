package cookatz.utility;

// 페이징 처리시 자주 사용되는 파라미터 목록을 문자열 결합해줍니다.
public class FlowParameters {
	private String pageNumber;
	private String pageSize;
	private String mode;
	private String keyword;
	
	public FlowParameters() {}
	
	public FlowParameters(String pageNumber, String pageSize, String mode, String keyword) {
		this.pageNumber = pageNumber;
		this.pageSize = pageSize;
		if(mode == null || mode.equals("null") || mode.equals("")) {
			mode = "all"; // 전체 검색 모드로 변경
		}
		this.mode = mode;
		if(keyword == null || keyword.equals("null") || keyword.equals("")) {
			keyword = "";
		}
		this.keyword = keyword;
	}

	@Override
	public String toString() {
		return "pageNumber=" + pageNumber + "&pageSize=" + pageSize + "&mode=" + mode + "&keyword=" + keyword;
	}
	public String getPageNumber() {
		return pageNumber;
	}
	public void setPageNumber(String pageNumber) {
		this.pageNumber = pageNumber;
	}
	public String getPageSize() {
		return pageSize;
	}
	public void setPageSize(String pageSize) {
		this.pageSize = pageSize;
	}
	public String getMode() {
		return mode;
	}
	public void setMode(String mode) {
		this.mode = mode;
	}
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	
	
}
