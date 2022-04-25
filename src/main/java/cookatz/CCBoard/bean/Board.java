package cookatz.CCBoard.bean;

public class Board {
	private int bo_no; // 게시글번호
	private String writer; // 작성한 관리자
	private String bo_category; // 카테고리 구분
	private String regdate; // 작성일
	private String title; // 게시글 제목
	private String video_upload; // 동영상 업로드 파일
	private String board_comment; // 글내용
	private int readhit; // 조회수
	private int likenum; // 추천수
	private String remark; // 비고
	
	
	public Board() {}
	
	@Override
	public String toString() {
		return "CookingClassBoard [bo_no=" + bo_no + ", writer=" + writer + ", bo_category=" + bo_category
				+ ", regdate=" + regdate + ", title=" + title + ", video_upload=" + video_upload + ", board_comment="
				+ board_comment + ", readhit=" + readhit + ", likenum=" + likenum + ", remark=" + remark + "]";
	}
	public int getBo_no() {
		return bo_no;
	}
	public void setBo_no(int bo_no) {
		this.bo_no = bo_no;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getBo_category() {
		return bo_category;
	}
	public void setBo_category(String bo_category) {
		this.bo_category = bo_category;
	}
	public String getRegdate() {
		return regdate;
	}
	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getVideo_upload() {
		return video_upload;
	}
	public void setVideo_upload(String video_upload) {
		this.video_upload = video_upload;
	}
	public String getBoard_comment() {
		return board_comment;
	}
	public void setBoard_comment(String board_comment) {
		this.board_comment = board_comment;
	}
	public int getReadhit() {
		return readhit;
	}
	public void setReadhit(int readhit) {
		this.readhit = readhit;
	}
	public int getLikenum() {
		return likenum;
	}
	public void setLikenum(int likenum) {
		this.likenum = likenum;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
}