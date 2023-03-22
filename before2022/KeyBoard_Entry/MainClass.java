package COMMON.KeyBoard_Entry;
/*
 * ��������ʾ���Զ��� ���±������Զ�¼������ַ���Ч��
 * �ص�ע��Robot���ʹ��
 * 
 * */
 import java.awt.Robot;
 import java.awt.event.KeyEvent;
public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("����ʼ");
		try{
			//�����Զ�������
			Robot robot = new Robot();
			//�������±�����
			Runtime.getRuntime().exec("cmd /c start notepad");
			
			//�ӳ����룬�ȴ����±������ɹ�
			robot.delay(3000);
			//ģ�ⰴ��ctrl+space�����������뷨  ���Ƿ����е��Ե��������뷨����CTRL+space)
			pressKeyWithCtrl(robot,KeyEvent.VK_SPACE);
			//ģ�ⰴ��shift���л����뷨Ϊ����
			pressKeyOfShift(robot);
			//ģ���������100����ĸ�����뺺��
			for(int i =0;i<100;i++){
				pressKey(robot,(int)(Math.random()*25)+'A');
				pressKey(robot,KeyEvent.VK_SPACE);
			}
			//�ӻ��������Թ��۲�
			robot.delay(3000);
			//�رռ��±�
			closeApplication(robot);
		}catch(Exception E){
			E.printStackTrace();
		}
	}
	public static void pressKeyOfShift(Robot robot){
		robot.keyPress(KeyEvent.VK_SHIFT);
		robot.keyRelease(KeyEvent.VK_SHIFT);
	}
	public static void pressKey(Robot robot,int keyValue){
		//ģ�ⰴ��
		robot.keyPress(keyValue);
		//ģ�ⵯ��
		robot.keyRelease(keyValue);
	}
	
	//ģ��ͬʱ����Ctrl+�ַ������ķ���
	public static void pressKeyWithCtrl(Robot robot,int keyValue){
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(keyValue);
		
		robot.keyRelease(keyValue);
		robot.keyRelease(KeyEvent.VK_CONTROL);
	}
	
	public static void closeApplication(Robot robot){
		robot.keyPress(KeyEvent.VK_ALT);
		robot.keyPress(KeyEvent.VK_F4);
		//�˴������·�VK_ALT��VK_F4��ֵ�Ƿ���Ӱ��
		robot.keyRelease(KeyEvent.VK_ALT);
		robot.keyRelease(KeyEvent.VK_F4);
		//ģ�ⰴ��N�����������ļ��˳����±�
		robot.keyPress(KeyEvent.VK_N);
		robot.keyRelease(KeyEvent.VK_N);
		
	}

}
