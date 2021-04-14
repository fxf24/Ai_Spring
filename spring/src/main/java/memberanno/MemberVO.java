package memberanno;

import org.springframework.stereotype.Component;

@Component("vo") //MemberVO vo = new MemberVO();
public class MemberVO {
	String id, pw;
	
	public MemberVO() {}
	
	public MemberVO(String id, String pw) {
		super();
		this.id = id;
		this.pw = pw;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}
	
}
