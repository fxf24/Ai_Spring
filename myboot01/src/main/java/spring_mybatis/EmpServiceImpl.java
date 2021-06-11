package spring_mybatis;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("service")
public class EmpServiceImpl implements EmpService{
	@Autowired
	EmpDAO dao;
	
	@Override
	public EmpVO getOneEmp(int employee_id) {
		EmpVO vo = dao.getOneEmp(employee_id);
		return vo; 
	}
	@Override
	public List<EmpVO> getAllEmp() {
		// dao 다른 메소드 호출 실행
		return dao.getAllEmp();
	}
	@Override
	public List<EmpVO> getEmpPage(int[] page) {
		// TODO Auto-generated method stub
		return dao.getEmpPage(page);
	}
	@Override
	public void registerEmp(EmpVO vo) {
		if(vo.getLast_name() != null) {
			EmpVO evo = dao.checkEmp(vo);
			String job_id = dao.checkJob(vo);
			System.out.println("evo=" + evo + ", job_id=" + job_id);
			if(evo==null && job_id != null) {
				dao.insertEmp(vo);
			}
		}
		//사번, 이메일 중복 검사
		//job_id - jobs 테이블 조회 존재 여부
		//last_name null 인지 여부 - db sql 실행을
		//insert
		
	}

}
