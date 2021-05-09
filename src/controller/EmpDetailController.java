package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.Emp;
import service.face.EmpService;
import service.impl.EmpServiceImpl;

@WebServlet("/emp/detail")
public class EmpDetailController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	//서비스 객체 
	private EmpService empService = new EmpServiceImpl();
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		System.out.println("/emp/detail [GET]");
		
		//요청정보로 부터 전달 파라미터 eno출력
	
		
		String param  = req.getParameter("eno");
			
				System.out.println("전달파라미터 eno : " + param );
		
		int empno =0; // 파라미터를 저장할 변수 

		if(param != null && !"".equals(param)) {
			
			empno = Integer.parseInt(param);
			
		} else {
			
			System.out.println("[Error] 전달 파라미터 잘못됨 - eno");
		}
		
		System.out.println("EmpDetailController - empno : " + empno);
		
		
		// 사원 정보 상세 조회하기 - EmpService객체 이용
		
		//Emp res = empService.detail(empno);
		
	
	
	//전달값을 저장할 emp DTO객체 생성 
		
		Emp emp = new Emp();
		emp.setEmpno(empno);
		
	    Emp res = empService.detail(emp); // DTO를 이용한 데이터 전달. 
	
	    System.out.println("EmpController -" + res);
	    
	  //조회결과(MODEL값)를 VIEW에 전달하기 - HttpServletRequest 객체 이용
	  		req.setAttribute("result", res);
	  		
	  		
	  		//View 지정하기 - HttpServletRequest객체, RequestDispatcher객체 이용
	  		//View를 응답으로 사용하기 - forward()메소드 이용
	  		req.getRequestDispatcher("/WEB-INF/views/emp/detail.jsp")
	  			.forward(req, resp);
	    
	}
	
}
