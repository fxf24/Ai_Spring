package spring_mybatis;

import java.util.List;

public interface EmpService {
	public EmpVO getOneEmp(int employee_id);
	public List<EmpVO> getAllEmp();
	public List<EmpVO> getEmpPage(int[] page);
	public void registerEmp(EmpVO vo);

}
