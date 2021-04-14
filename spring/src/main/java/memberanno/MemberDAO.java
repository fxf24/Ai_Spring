package memberanno;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

@Repository("dao")
public class MemberDAO {
	@Autowired
	@Qualifier("vo2")//vo2를 우선해서 사용
	MemberVO vo; //MemberVO 2개이상 생성됐다면 어떤걸 사용할지 정하라
	
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
