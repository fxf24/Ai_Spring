package spring_mybatis;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("service")
public class EmpServiceImpl implements EmpService{
	@Autowired
	EmpDAO dao;
	
	public void setDao(EmpDAO dao) {
		this.dao = dao;
	}
	@Override
	public EmpVO getOneEmp(int employee_id) {
		EmpVO vo = dao.getEmp(employee_id);
		return vo; 
	}
	@Override
	public List<EmpVO> getAllEmp() {
		// dao 다른 메소드 호출 실행
		return dao.getAllEmp();
	}
	@Override
	public void insertEmp(EmpVO vo) {
		dao.insertEmp(vo);
	}
	@Override
	public void updateEmp(EmpVO vo) {
		if(dao.getEmp(vo.getEmployee_id()) != null) {
			dao.updateEmp(vo);
		}
	}
	@Override
	public void deleteEmp(int employee_id) {
		dao.deleteEmp(employee_id);
	}
	@Override
	public List<EmpVO> getPageEmp(int[] nums) {
		return dao.getPageEmp(nums);
	}
	@Override
	public void insertEmp2(EmpVO vo) {
		dao.insertEmp2(vo);
	}
	@Override
	public List<EmpVO> getEmpDept(List<Integer> deptlist) {
		return dao.getEmpDept(deptlist);
	}
	
	@Override
	public void updateMap(Map<String, String> map) {
		dao.updateEmp(map);
	}
}
