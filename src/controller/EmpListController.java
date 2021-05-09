package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.Emp;
import service.face.EmpService;
import service.impl.EmpServiceImpl;

@WebServlet("/emp/list")
public class EmpListController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	//EmpService 객체 생성 
	 
	private EmpService empService = new EmpServiceImpl();
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		System.out.println("EmpListController [GET] - 요청성공");
		
		//Emp테이블의 전체 목록을 조회 - EmpService 이용 
		
		List<Emp> empList = empService.list();
		
		
		//[TEST] 조회 결과 확인 :
//		for (Emp e : empList) 		System.out.println(e);
		
		
		//조회된 결과를 JSP(View)에 전달하기 
		// -> "list"라는 이름으로 JSP코드에 empList객체를 전달한다. 
		req.setAttribute("list", empList);
		
		//JSP를 View 지정하고 응답으로 사용하기
		
		req.getRequestDispatcher("/WEB-INF/views/emp/list.jsp")
			.forward(req, resp);
		
		
		
	}
	
	
		
}







