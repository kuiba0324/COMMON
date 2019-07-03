package COMMON.FrameProrerty;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

//常见的窗体属性设置

public class MainClass {
	public static void main(String[] args){
		System.out.println("程序开始");
		MyFrame myframe = new MyFrame();
	}
}

class MyFrame extends JFrame{
	public MyFrame(){
		//设置窗体标题
		this.setTitle("demo");
		setBackground(Color.white);
		//设置窗体德最大尺寸和相应位置
		Rectangle bounds = new Rectangle(100,100,100,100);		//Rectangle;
		this.setMaximizedBounds(bounds);
		Toolkit thekit =  this.getToolkit();
		Dimension demoSize = thekit.getScreenSize();
		setBounds(demoSize.width/3,demoSize.height/3,demoSize.width/3,demoSize.height/3);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		//设置窗体图标
		Image icon = Toolkit.getDefaultToolkit().getImage("src/COMMON/FrameProrerty/java.jpg");
		//Image icon = Toolkit.getDefaultToolkit().getImage("src/COMMON/FrameProrerty/young7.png");
		if(icon != null){
			System.out.println("非空");
		}
		this.setIconImage(icon);
		//设置窗体光标
		this.setCursor(Cursor.TEXT_CURSOR);
		//设置窗体无法最小化
		this.addWindowListener(new WindowAdapter(){				
			public void windowIconified(WindowEvent e){	//当窗口图标化时调用
				setState(Frame.NORMAL);
			}
		});
		
		this.setVisible(true);
		
		
	}
}
