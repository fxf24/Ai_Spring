package emp;

public class EmpMain {

	public static void main(String[] args) {
		VO vo = new EmpVO();
		vo.setId(100);
		vo.setName("�̻��");
//		vo.setSalary(12300);
		System.out.println("DB��� �Ϸ��߽��ϴ�");
		VO vo2 = new MemberVO();
		vo2.setId(100);
		vo2.setName("�̻��");
//		vo2.setEmail("123@23425.com");;
		
		EmpDAO dao = new EmpDAO();
		dao.insertEmp(vo2);// ����
		System.out.println("ȸ����� ���ƽ��ϴ�");
	}

}
