package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import common.JDBCTemplate;
import dao.face.EmpDao;
import dto.Emp;

public class EmpDaoImpl implements EmpDao {

	@Override
	public List<Emp> selectAll(Connection conn) {
	
		PreparedStatement ps = null ; // SQL수행 객체 
		ResultSet rs =null; // 조회결과 객체 
		
		
		//--- Sql 작성 -----
		String sql = "";
		sql += "SELECT * FROM emp";
		sql += " ORDER BY empno";
		//-------------------
		
		//---조회 결과를 저장할 List ----
		List<Emp> list = new ArrayList<>();
		//-------------------------------
		
		try {
			//SQL 수행 객체생성 ---
			ps =conn.prepareStatement(sql);
			//---------------------
			
			//sql 수행 및 결과 저장 ----
			rs  =ps.executeQuery();
			//---------------------
			
			//--- 조회 결과 처리 ---
			while(rs.next()) {
				
				//각 행의 데이터를 저장할 Emp객체 생성
				Emp emp = new Emp();
				
				emp.setEmpno( rs.getInt("empno") );
				emp.setEname( rs.getString("ename") );
				emp.setJob( rs.getString("job") );
				emp.setMgr( rs.getInt("mgr") );
				emp.setHiredate( rs.getDate("hiredate") );
				emp.setSal( rs.getDouble("sal") );
				emp.setComm( rs.getDouble("comm") );
				emp.setDeptno( rs.getInt("deptno") );
				
				//조회결과를 담고있는 Emp객체를 리스트에 추가하기
				list.add(emp);
			}
			//----------------------
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
				try {
				if(rs!=null) rs.close();
				if(ps!=null) ps.close();
				
				} catch (SQLException e) {	
					
					e.printStackTrace();
				} finally {
					//----자원 해제  -----
					JDBCTemplate.close(rs);
					JDBCTemplate.close(ps);
				}
			
		}
		
		//최종 조회 결과 반환 
		return list;
	}

	@Override
	public Emp selectByEmpno(Connection conn, Emp emp) {
		
		System.out.println("EmpDAo - selectByEmpno() 호출");
		System.out.println(emp);
		
		PreparedStatement ps = null; // SQL 수행 객
		ResultSet rs = null; // 결과 집합 객체 
		
		String sql = "";
		sql += "SELECT * FROM emp";
		sql += " WHERE empno =?";
		
		Emp res = null; // 조회된 결과를 저장할 객체 
		
		try {
			ps = conn.prepareStatement(sql);//SQL수행객
			ps.setInt(1, emp.getEmpno()); // ? 값 채워주기 
			
			rs = ps.executeQuery(); // SQL 수행 및 결과 반환 
		
			while(rs.next()) {
				res = new Emp();
				
				res.setEmpno(rs.getInt("empno"));
				res.setEname(rs.getString("ename"));
				res.setJob(rs.getString("job"));
				res.setMgr(rs.getInt("mgr"));
				res.setHiredate(rs.getDate("hiredate"));
				res.setSal(rs.getDouble("sal"));
				res.setComm(rs.getInt("comm"));
				res.setDeptno(rs.getInt("deptno"));
				
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			//자원해제  
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
		
		
		System.out.println("EmpDao - " + res );
		
		return res;
	}
}
