package spring_mybatis;

import java.util.List;
import java.util.Map;

public interface EmpService {
	public EmpVO getOneEmp(int employee_id);
	public List<EmpVO> getAllEmp();
	public void insertEmp(EmpVO vo);
	public void updateEmp(EmpVO vo);
	public void deleteEmp(int employee_id);
	public List<EmpVO> getPageEmp(int[] nums);
	public void insertEmp2(EmpVO vo);
	public List<EmpVO> getEmpDept(List<Integer> deptlist);
	public void updateMap(Map<String, String> map);
}
