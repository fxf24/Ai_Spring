package tv;

public class TVFactory {
	public static TV getTV(String name) {
		if(name.equals("엘지티비")) {
			return new LGTV();
		}
		else if(name.equals("삼성티비")) {
			return new SamsungTV();
		}
		return null;
	}
}
