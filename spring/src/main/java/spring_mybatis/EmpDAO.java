package spring_mybatis;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Repository("dao")
public class EmpDAO {
	@Autowired
	SqlSession session;

	public void setSession(SqlSession session) {
		this.session = session;
	}
	
	public EmpVO getEmp(int employee_id) {
		EmpVO vo = session.selectOne("employees.oneEmp", employee_id);
		return vo; 
	}
	
	public List<EmpVO> getAllEmp() {
		List<EmpVO> vo= session.selectList("employees.manyEmp");
		return vo;
	}
	
	public void insertEmp(EmpVO vo) {
		session.insert("employees.insertEmp", vo);
	}
	
	public void updateEmp(EmpVO vo) {
		session.update("employees.updateEmp",vo);
	}
	
	public void deleteEmp(int employee_id) {
		session.delete("employees.deleteEmp", employee_id);
	}
	
	public List<EmpVO> getPageEmp(int[] nums){
		return session.selectList("employees.pageEmp", nums);
	}
	
	public void insertEmp2(EmpVO vo) {
		session.insert("employees.insertEmp2", vo);
	}
	
	public List<EmpVO> getEmpDept(List<Integer> deptlist){
		List<EmpVO> list = session.selectList("employees.selectwithlist", deptlist);
		return list;
	}
	
	public void updateEmp(Map<String, String> map) {
		session.update("employees.updatewithmap", map);
	}
}
