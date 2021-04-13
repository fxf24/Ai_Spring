package tv;

public class TVFactory {
	public static TV getTV(String name) {
		if(name.equals("¿¤ÁöÆ¼ºñ")) {
			return new LGTV();
		}
		else if(name.equals("»ï¼ºÆ¼ºñ")) {
			return new SamsungTV();
		}
		return null;
	}
}
