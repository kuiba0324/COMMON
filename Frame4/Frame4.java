package COMMON.Frame4;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JWindow;

//ȫ����ʾ�Ĵ���

public class Frame4 {
	public static void main(String args[]) {
		System.out.println("����ʼ,ȫ����ʾ����");
		DemoWindow demo = new DemoWindow();
	}
}

class DemoWindow extends JWindow {
	// ��ʾ��Ϣ��ǩ
	JLabel jl = new JLabel("java", JLabel.CENTER);

	public DemoWindow(){
		jl.setFont(new Font("Arial",Font.BOLD,72));
		//���岼��
		this.add(jl,BorderLayout.CENTER);
		this.setVisible(true);
		//��ȡͼ�λ���		??
		GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		//��ȡĬ�ϵ���ʾ�豸
		GraphicsDevice gd = ge.getDefaultScreenDevice();
		//�����ʾ�豸֧��ȫ������ȫ����ʾ
		if(gd.isFullScreenSupported()){
			gd.setFullScreenWindow(this);
		}
		//����¼�������
		this.addMouseListener(new ExitHandler(this));
		System.out.println(ge.getCenterPoint());
		for(int i = 0;i<ge.getAvailableFontFamilyNames().length;i++)
			System.out.println(ge.getAvailableFontFamilyNames()[i]);
	}
}

// �˳�������¼�������
class ExitHandler extends MouseAdapter {
	// ��������
	JWindow jf = null;

	public ExitHandler(JWindow jf) {
		this.jf = jf;
	}

	// ��Ӧ�����¼�
	public void mousePressed(MouseEvent evt) {
		// �ͷ���Դ�˳�����
		jf.dispose();
		System.exit(0);
	}
}
