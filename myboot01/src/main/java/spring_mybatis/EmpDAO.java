package spring_mybatis;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper//@MapperScan
@Repository("dao")//@ComponentScan
public interface EmpDAO {

	public EmpVO getOneEmp(int employee_id);	
	public List<EmpVO> getAllEmp();
	public List<EmpVO> getEmpPage(int[] page);
	
	public EmpVO checkEmp(EmpVO vo); //사번, 이메일 중복 검사 - 결과 존재하면 사번이나 이메일 등록 불가
	public String checkJob(EmpVO vo);
	public void insertEmp(EmpVO vo);
}
