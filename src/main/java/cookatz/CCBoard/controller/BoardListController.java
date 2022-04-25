package cookatz.CCBoard.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cookatz.CCBoard.bean.Board;
import cookatz.CCBoard.dao.BoardDao;
import cookatz.common.controller.SuperClass;
import cookatz.utility.FlowParameters;
import cookatz.utility.Paging;

public class BoardListController extends SuperClass{
	BoardDao bdao = null;
	
	public BoardListController() {
		this.bdao = new BoardDao();
	}
			
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super.doProcess(request, response);
		
		FlowParameters parameters 
		= new FlowParameters(
				request.getParameter("pageNumber"), 
				request.getParameter("pageSize"), 
				request.getParameter("mode"), 
				request.getParameter("keyword")) ;
	
		System.out.println(this.getClass() + " : " + parameters.toString() );
		
		int totalCount 
			= this.bdao.GetTotalCount(
				parameters.getMode(), 
				parameters.getKeyword()) ; 
		
		String url = super.getUrl("CCBoList") ;
		
		Paging pageInfo 
			= new Paging(
					parameters.getPageNumber(), 
					parameters.getPageSize(), 
					totalCount, 
					url, 
					parameters.getMode(), 
					parameters.getKeyword()) ;
		
		List<Board> lists 
			= this.bdao.PagingInfo(
					pageInfo.getBeginRow(), 
					pageInfo.getEndRow(),
					parameters.getMode(), 
					parameters.getKeyword()) ;
		
		System.out.println("게시물 건수 : " + lists.size());
		
		// 표로 보여줄 컬렉션 정보 
		request.setAttribute("lists", lists);
		
		// 페이징 관련된 항목들
		request.setAttribute("pageInfo", pageInfo);
		
		// 상세 보기, 수정. 삭제, 답글 등의 링크에 사용될 파라미터 리스트 문자열
		request.setAttribute("parameters", parameters);
		
		String gotopage = "/CCBoard/boList.jsp";
		super.GotoPage(gotopage);
	}
}
