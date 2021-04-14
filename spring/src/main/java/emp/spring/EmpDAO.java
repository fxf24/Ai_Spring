package emp.spring;

public class EmpDAO {
	void insertEmp(VO vo){
		//사원정보를 다른 객체로부터 전달받는다=주입받는다=injection(매개변수 객체)
		//EmpDAO 결정한 객체 아니라 외부로부터 전달받은 객체 호환
		if(vo instanceof EmpVO) {
			EmpVO e = (EmpVO)vo;
			System.out.println(e.getId() + ":" + e.getName());
		}
		else if(vo instanceof MemberVO) {
			MemberVO m = (MemberVO)vo;
			System.out.println(m.getId() + ":" + m.getName());
		}
		
		System.out.println("db 등록 완료했습니다.");
	}
}
