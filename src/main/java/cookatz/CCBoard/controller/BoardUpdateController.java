package cookatz.CCBoard.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;

import cookatz.CCBoard.bean.Board;
import cookatz.CCBoard.dao.BoardDao;
import cookatz.common.controller.SuperClass;

public class BoardUpdateController extends SuperClass{
	BoardDao bdao = null;
	Board bean = null;
	
	public BoardUpdateController() {
		this.bdao = new BoardDao();
		this.bean = new Board();
	}
			
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super.doProcess(request, response);
		
		int bo_no = Integer.parseInt(request.getParameter("bo_no"));
		this.bean = this.bdao.SelectOne(bo_no);
		
		request.setAttribute("bean", this.bean);
		
		String gotopage = "/CCBoard/boUpdateForm.jsp";
		super.GotoPage(gotopage);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super.doProcess(request, response);
		
		// 이미지 업로드인 경우에는 FrontController 에서 MultipartRequest 객체 mr이 request에 바인딩됩니다.
		// mr 객체를 doPost() 메소드에서 파라미터를 처리해 주면 됩니다.
		MultipartRequest mr = (MultipartRequest)request.getAttribute("mr");
		
		// 파라미터 챙기기
		//int bo_no = Integer.parseInt(mr.getParameter("bo_no"));
		String writer = mr.getParameter("writer");
		String bo_category = mr.getParameter("bo_category");
		//String regdate = mr.getParameter("regdate");
		String title = mr.getParameter("title");
		
		// 이미지는 객체이므로 getFilesystemName() 메소드를 사용
		//String video_upload = mr.getFilesystemName("video_upload");
		
		String video_upload = mr.getParameter("video_upload");
		
		String board_comment = mr.getParameter("board_comment");
		//int readhit = Integer.parseInt(mr.getParameter("readhit"));
		//int likenum = Integer.parseInt(mr.getParameter("likenum"));
		//String remark = mr.getParameter("remark");
		
		// bean 객체에 세팅하기
		this.bean.setBo_category(bo_category);
		// this.bean.setBo_no(0); // by sequence
		this.bean.setBoard_comment(board_comment);
		this.bean.setLikenum(0);
		this.bean.setReadhit(0);
		//this.bean.setRegdate(regdate);  // use default value
		this.bean.setRemark("");
		this.bean.setTitle(title);
		this.bean.setVideo_upload(video_upload);
		this.bean.setWriter(writer);
		
		System.out.println(this.getClass() + "doPost()");
		System.out.println(bean);
		
		// dao를 이용하여 데이터 베이스에 수정해 줍니다.
		bdao.UpdateData(bean);
		
		// 게시물 목록 페이지로 이동
		new BoardListController().doGet(request, response);
		
	}
}
