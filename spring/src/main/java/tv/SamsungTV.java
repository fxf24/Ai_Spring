package tv;

public class SamsungTV implements TV{
	public void powerOn() {
		System.out.println("삼성 tv- 전원 켜다");
	}
	public void powerOff() {
		System.out.println("삼성 tv- 전원 끄다");
	}
	public void soundUp() {
		System.out.println("삼성 tv- 소리 키우다");
	}
	public void soundDown() {
		System.out.println("삼성 tv- 소리 줄이다");
	}
}
