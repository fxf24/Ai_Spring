package member;

public class MemberDAO {
	MemberVO vo;
	
	public void setMemberVO(MemberVO vo) {
		this.vo = vo;
	}
	
	public boolean selectMember() {
		if(vo.getId().equals("spring") && vo.getPw().equals("work")) {
			return true;
		}
		else {
			return false;
		}
	}
	public void insertMember() {
		System.out.println(vo.getId() + "회원님 정상 가입하셨습니다");
	}
}
