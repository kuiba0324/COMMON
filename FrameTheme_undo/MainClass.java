package COMMON.FrameTheme_undo;

import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.UIManager;

//import com.sun.media.sound.Toolkit;

import napkin.NapkinLookAndFeel;

//����office 2003����Ĵ���
public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//װ��office2003����
		DemoWindow demo = new DemoWindow("Office 2003����ļ��±�");
		//demo.setUndecorated(true);
		try{
			//װ��Office2003����
			//UIManager.setLookAndFeel("org.fife.plaf.Office2003.Office2003LookAndFeel");
			UIManager.setLookAndFeel("napkin.NapkinLookAndFeel");
			//UIManager.setLookAndFeel(new NapkinLookAndFeel());
			//װ��ƻ������
			//UIManager.setLookAndFeel("ch.randelshofer.quaqua.QuaquaLookAndFeel");
		
		}catch(Exception e){
			System.out.println(e.getMessage()+"������");
			
		}
		//�������������
		//DemoWindow demo = new DemoWindow("Office 2003����ļ��±�");
		//demo.setUndecorated(true);
		//demo.setUndecorated(false);
		//���ô�����
		Toolkit thekit = demo.getToolkit();
		Dimension winSize = thekit.getScreenSize();
		demo.setBounds(winSize.width/3,winSize.height/3,winSize.width/3,winSize.height/3);
		demo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}

}
class DemoWindow extends JFrame{
	public DemoWindow (String s){
		super(s);
		this.setUndecorated(true);
		this.setVisible(true);
		//JFrame.setDefaultLookAndFeelDecorated(true);
	}
}
