package COMMON.FrameTheme_undo;

import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.UIManager;

//import com.sun.media.sound.Toolkit;

import napkin.NapkinLookAndFeel;

//具有office 2003主题的窗体
public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//装载office2003主题
		DemoWindow demo = new DemoWindow("Office 2003主题的记事本");
		//demo.setUndecorated(true);
		try{
			//装载Office2003主题
			//UIManager.setLookAndFeel("org.fife.plaf.Office2003.Office2003LookAndFeel");
			UIManager.setLookAndFeel("napkin.NapkinLookAndFeel");
			//UIManager.setLookAndFeel(new NapkinLookAndFeel());
			//装载苹果主题
			//UIManager.setLookAndFeel("ch.randelshofer.quaqua.QuaquaLookAndFeel");
		
		}catch(Exception e){
			System.out.println(e.getMessage()+"出错了");
			
		}
		//创建窗体类变量
		//DemoWindow demo = new DemoWindow("Office 2003主题的记事本");
		//demo.setUndecorated(true);
		//demo.setUndecorated(false);
		//设置窗体宽高
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
