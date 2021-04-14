package emp;

public class EmpMain {

	public static void main(String[] args) {
		VO vo = new EmpVO();
		vo.setId(100);
		vo.setName("이사원");
//		vo.setSalary(12300);
		System.out.println("DB등록 완료했습니다");
		VO vo2 = new MemberVO();
		vo2.setId(100);
		vo2.setName("이사원");
//		vo2.setEmail("123@23425.com");;
		
		EmpDAO dao = new EmpDAO();
		dao.insertEmp(vo2);// 주입
		System.out.println("회원등록 마쳤습니다");
	}

}
