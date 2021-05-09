package dto;

import java.util.Date;

public class Emp {
	//선택한 내용 전부 소문자로 변경 : ctrl + shift + y
	//선택한 내용 전부 대문자로 변경 : ctrl + shift + x
	
	//toString 자동 생성 단축키 : alt + shift + s, s
	//getters, setters 자동 생성 단축키 : alt + shift + s, r
	
	
	private int empno;  // 직원 번호
	private String ename; // 직원이름 
	private String job; //직업 
	private int mgr;  //  매니저 
	private Date hiredate;  // 고용날짜 
	private double sal; // 월급 
	private double comm; // 커미션 
	private int deptno; // 부서번호 
	
	@Override
	public String toString() {
		return "Emp [empno=" + empno + ", ename=" + ename + ", job=" + job + ", mgr=" + mgr + ", hiredate=" + hiredate
				+ ", sal=" + sal + ", comm=" + comm + ", deptno=" + deptno + "]";
	}
	
	public int getEmpno() {
		return empno;
	}
	public void setEmpno(int empno) {
		this.empno = empno;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public int getMgr() {
		return mgr;
	}
	public void setMgr(int mgr) {
		this.mgr = mgr;
	}
	public Date getHiredate() {
		return hiredate;
	}
	public void setHiredate(Date hiredate) {
		this.hiredate = hiredate;
	}
	public double getSal() {
		return sal;
	}
	public void setSal(double sal) {
		this.sal = sal;
	}
	public double getComm() {
		return comm;
	}
	public void setComm(double comm) {
		this.comm = comm;
	}
	public int getDeptno() {
		return deptno;
	}
	public void setDeptno(int deptno) {
		this.deptno = deptno;
	}
	
}
