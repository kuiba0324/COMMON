package COMMON.KeyBoard_Entry;

import java.awt.Robot;

/*
 * ����robot�Ĳ�����
 * ��������Ϊ�����Զ�������������ʾ�����������Ҫ�������ͼ��̵�Ӧ�ó������ɱ���ϵͳ�����¼���Robot ����ҪĿ���Ǳ��� Java ƽ̨ʵ���Զ����ԡ�
 *  ʹ�ø������������¼��뽫�¼����͵� AWT �¼����л� AWT ������������ڣ��¼�����ƽ̨�ı���������������ɵġ����磬Robot.mouseMove ��ʵ���ƶ�����꣬������ֻ��������ƶ��¼���
 *  ע�⣬ĳЩƽ̨��Ҫ�ض�Ȩ�޻���չ�����ʵͼ�����ؼ��������ǰƽ̨���ò�����ʹ������ؼ�����ô��ͼ���� Rob00000000000000000000000000000000ot ����ʱ���׳� AWTException��
 *  ���磬��� X ��������֧�֣���û�����ã�XTEST 2.2 ��׼��չ���� X-Window ϵͳ���׳��쳣��
 *  �����Բ���֮���Ŀ�Ķ�ʹ�� Robot ��Ӧ�ó���Ӧ���ƴ�����Щ���������� 
 *  
 *  --ժ�ԣ�http://tool.oschina.net/apidocs/apidoc?api=jdk-zh
 * */
public class TestClassOfRobot {
	public static void main(String[] args){
		System.out.println("����ʼ");
		try {
			java.awt.Robot robot = new Robot();
			robot.delay(3000);
			robot.mouseMove(800, 409);
			robot.mouseWheel(10);
			robot.mousePress(java.awt.event.InputEvent.BUTTON1_MASK);
			robot.mouseRelease(java.awt.event.InputEvent.BUTTON1_MASK);
		
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			System.out.println("�������");
		}
	}
}
