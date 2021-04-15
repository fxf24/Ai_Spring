package mybatis;

import java.util.List;

public class EmpServiceImpl implements EmpService{
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
		// TODO Auto-generated method stub
		dao.insertEmp(vo);
	}
	@Override
	public void updateEmp(EmpVO vo) {
		// TODO Auto-generated method stub
		if(dao.getEmp(vo.getEmployee_id()) != null) {
			dao.updateEmp(vo);
		}
	}
	@Override
	public void deleteEmp(int employee_id) {
		// TODO Auto-generated method stub
		dao.deleteEmp(employee_id);
	}
	@Override
	public List<EmpVO> getPageEmp(int[] nums) {
		// TODO Auto-generated method stub
		return dao.getPageEmp(nums);
	}
	@Override
	public void insertEmp2(EmpVO vo) {
		// TODO Auto-generated method stub
		dao.insertEmp2(vo);
	}
}
