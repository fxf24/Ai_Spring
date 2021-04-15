package mybatis;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

public class EmpDAO {
	SqlSession session;

	public void setSession(SqlSession session) {
		this.session = session;
	}
	
	public EmpVO getEmp(int employee_id) {
		EmpVO vo = session.selectOne("emp.oneEmp", employee_id);
		return vo; 
	}
	
	public List<EmpVO> getAllEmp() {
		List<EmpVO> vo= session.selectList("emp.manyEmp");
		return vo;
	}
	
	public void insertEmp(EmpVO vo) {
		session.insert("emp.insertEmp", vo);
	}
	
	public void updateEmp(EmpVO vo) {
		session.update("emp.updateEmp",vo);
	}
	
	public void deleteEmp(int employee_id) {
		session.delete("emp.deleteEmp", employee_id);
	}
	
	public List<EmpVO> getPageEmp(int[] nums){
		return session.selectList("emp.pageEmp", nums);
	}
	
	public void insertEmp2(EmpVO vo) {
		session.insert("emp.insertEmp2", vo);
	}
}
