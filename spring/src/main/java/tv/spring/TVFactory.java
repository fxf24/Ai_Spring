package tv.spring;

public class TVFactory {
	public static TV getTV(String name) {
		if(name.equals("����Ƽ��")) {
			return new LGTV();
		}
		else if(name.equals("�ＺƼ��")) {
			return new SamsungTV();
		}
		return null;
	}
}
