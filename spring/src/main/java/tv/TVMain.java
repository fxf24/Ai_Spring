package tv;

public class TVMain {

	//tv 객체 변경하니 같이 변경 코드 따라오더라 - coupling 높다
	//A B  커플링 낮은 코드 필요
	//인터페이스 - 메소드 선언 -> 상속 하위클래스들 표준화 메소드 오버라이딩
	//엘지티비 / 삼성티비
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TV tv = TVFactory.getTV(args[0]);
			
		tv.powerOn();
		tv.soundUp();
		tv.soundDown();
		tv.powerOff();
		
		
	}
	

}
