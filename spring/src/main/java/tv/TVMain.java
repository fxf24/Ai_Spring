package tv;

public class TVMain {

	//tv ��ü �����ϴ� ���� ���� �ڵ� ��������� - coupling ����
	//A B  Ŀ�ø� ���� �ڵ� �ʿ�
	//�������̽� - �޼ҵ� ���� -> ��� ����Ŭ������ ǥ��ȭ �޼ҵ� �������̵�
	//����Ƽ�� / �ＺƼ��
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TV tv = TVFactory.getTV(args[0]);
			
		tv.powerOn();
		tv.soundUp();
		tv.soundDown();
		tv.powerOff();
		
		
	}
	

}
