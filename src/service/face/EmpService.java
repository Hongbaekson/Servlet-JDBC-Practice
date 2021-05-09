package service.face;

import java.util.List;

import dto.Emp;

public interface EmpService {

  /**
   * 사원 전체 조회 메소드 
   * @return 조회된 전체 사원들의 목록을 list로 반환한다. 
   */
	public List<Emp> list();

	/**
	 * 사원 정보 상세 조회 
	 * 
	 * @param emp - 조회할 사원번호를  가진 DTO 객체 
	 * @return 조회된 사원의 상세정보 , 모든 컬럼의 값을 가지고 있다. 
	 */
    public Emp detail(Emp emp);

	
}
