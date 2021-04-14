package tv.spring;

public class LGTV implements TV {
	public void powerOn() {
		System.out.println("LGTV- 전원 켜다");
	}
	public void powerOff() {
		System.out.println("LGTV- 전원 끄다");
	}
	public void soundUp() {
		System.out.println("LGTV- 소리 높이다");
	}
	public void soundDown() {
		System.out.println("LGTV- 소리 낮추다");
	}
}
