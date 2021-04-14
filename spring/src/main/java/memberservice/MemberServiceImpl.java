package memberservice;

public class MemberServiceImpl implements MemberService{
	MemberDAO dao;
	//ioc 제공 - di 구현 - setter injection / constructor injection
	//스프링 setter injection <property name="" ref=""
	
	public void setMemberDAO(MemberDAO dao) {
		this.dao = dao;
	}
	@Override
	public void register() {
		boolean result = dao.selectMember();
		if(!result) {
			dao.insertMember();
		}
	}

	@Override
	public void login() {
		boolean result = dao.selectMember();
		if(result) {
			System.out.println("정상 로그인 사용자");
		}
	}

}
