package COMMON.Frame6;

import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;


//͸������

public class Frame6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("����ʼ");
		DemoWindow demo = new DemoWindow("͸������");
	}

}

class DemoWindow extends JFrame implements ChangeListener{
	//������
	JSlider js =new JSlider(1,100);
	//�������
	JPanel jp = new JPanel();
	//��ʾ�ı���ǩ
	JLabel jl = new JLabel("��ӭ",JLabel.CENTER);
	public DemoWindow(String title){
		super(title);
		//���ñ�ǩ����
		jl.setFont(new Font("����",Font.BOLD,32));
		//���û�������ʼֵ
		js.setValue(100);
		jp.add(js);
		this.add(jl,BorderLayout.CENTER);
		this.add(jp,BorderLayout.SOUTH);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		//����¼�������
		js.addChangeListener(this);
		this.setBounds(90,90,600,400);
		setUndecorated(true);			
		/*���û����ô˴����װ�Ρ�ֻ���ڴ��岻����ʾʱ�ŵ��ô˷���
		 * ������������setvisible֮ǰ
		 * - ��������ǿ���ʾ��,�׳�IllegalComponentStateException�쳣
		*/
		this.setVisible(true);	
		/*
		 * --The following conditions must be met in order to set the opacity value less than 1.0f:
		 * 1.The TRANSLUCENT translucency must be supported by the underlying system
		 * 2.The window must be undecorated (see setUndecorated(boolean) and Dialog.setUndecorated(boolean))
		 * 3.The window must not be in full-screen mode (see GraphicsDevice.setFullScreenWindow(Window))
		 * If the requested opacity value is less than 1.0f, and any of the above conditions are not met, the window opacity 
		 * will not change�� and the IllegalComponentStateException will be thrown.
		 * 
		 *����setUndecorated()����ʱ��Frame��visible�������Ա�����false�����Ը��д��������setVisible֮ǰ
		 */
		/*Ϊʲô�øöδ����������в���
		 * this.setVisible(true);	
		this.setVisible(false);
		setUndecorated(true);	
		this.setVisible(true);
		 * */	
		
		//JFrame.setDefaultLookAndFeelDecorated(true);
		System.out.println("�������1");
		
		
		
		
		
	}
	//��Ӧ����
	@Override
	public void stateChanged(ChangeEvent e) {
		//���ô���͸����
		com.sun.awt.AWTUtilities.setWindowOpacity(this, js.getValue()/100.0F);
	}		
	
	
}
