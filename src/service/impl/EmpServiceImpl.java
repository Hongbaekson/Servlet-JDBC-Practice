package service.impl;

import java.sql.Connection;
import java.util.List;

import common.JDBCTemplate;
import dao.face.EmpDao;
import dao.impl.EmpDaoImpl;
import dto.Emp;
import service.face.EmpService;

public class EmpServiceImpl implements EmpService {
	//DAO 객체 생성 
	private EmpDao empDao = new EmpDaoImpl();
	
	
	@Override
	public List<Emp> list() {
		
		System.out.println("EmpService - list() 호출");
		
		//Connection 객체 생성
		Connection conn = JDBCTemplate.getConnection();
		
		
		//EMP테이블 전체 조회 - EmpDao 객체 이용 
		List<Emp> empList = empDao.selectAll(conn);
		
		//조회된 결과 반환 
		return empList;
	}


	@Override
	public Emp detail(Emp emp) {
		
		System.out.println("EmpService - Detail() 호출");
		System.out.println(emp);
		
		//Connection 객체 생성 
		
		Connection conn = JDBCTemplate.getConnection();
		
		
		//DB조회 결과 얻어오기 -DAO 이용
		
		Emp res = empDao.selectByEmpno(conn,emp);
		
		System.out.println("EmpService - " + res);
		//조회결과 리턴 
		
		return res;
		
	
	}

	
}
