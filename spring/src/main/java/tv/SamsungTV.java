package tv;

public class SamsungTV implements TV{
	public void powerOn() {
		System.out.println("삼성 tv - 전원켜다");
	}
	public void powerOff() {
		System.out.println("삼성 tv - 전원끄다");
	}
	public void soundUp() {
		System.out.println("삼성 tv - 소리 높이다");
	}
	public void soundDown() {
		System.out.println("삼성 tv - 소리 낮추다");
	}
}
