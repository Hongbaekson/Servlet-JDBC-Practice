package dao.face;

import java.sql.Connection;
import java.util.List;

import dto.Emp;

public interface EmpDao {
	
	//테이블 전체 조회 
	/**
	 * 테이블 전체조회 
	 * @param conn - DB연결 객체 
	 * @return 조회된 전체 EMP 테이블의 목록을 List로 반환한다. 
	 */
	public List<Emp> selectAll(Connection conn);
	
	/**
	 * 전달된 emp객체의 empno필드를 이용하여 사원 정보를 조회한다. 
	 * @param  - DB연결 객
	 * @param  - 조회할 사원의 empno를 가진 DTO객체 
	 * @return - 조회된 사원 정보를 Emp객체로 반환한다. 
	 */
	public Emp selectByEmpno(Connection conn, Emp emp);

	
}
