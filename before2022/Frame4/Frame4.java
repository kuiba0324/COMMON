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

//全屏显示的窗体

public class Frame4 {
	public static void main(String args[]) {
		System.out.println("程序开始,全屏显示窗体");
		DemoWindow demo = new DemoWindow();
	}
}

class DemoWindow extends JWindow {
	// 提示信息标签
	JLabel jl = new JLabel("java", JLabel.CENTER);

	public DemoWindow(){
		jl.setFont(new Font("Arial",Font.BOLD,72));
		//窗体布局
		this.add(jl,BorderLayout.CENTER);
		this.setVisible(true);
		//获取图形环境		??
		GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		//获取默认的显示设备
		GraphicsDevice gd = ge.getDefaultScreenDevice();
		//如果显示设备支持全屏，则全屏显示
		if(gd.isFullScreenSupported()){
			gd.setFullScreenWindow(this);
		}
		//添加事件监听器
		this.addMouseListener(new ExitHandler(this));
		System.out.println(ge.getCenterPoint());
		for(int i = 0;i<ge.getAvailableFontFamilyNames().length;i++)
			System.out.println(ge.getAvailableFontFamilyNames()[i]);
	}
}

// 退出程序的事件处理类
class ExitHandler extends MouseAdapter {
	// 窗体引用
	JWindow jf = null;

	public ExitHandler(JWindow jf) {
		this.jf = jf;
	}

	// 响应单击事件
	public void mousePressed(MouseEvent evt) {
		// 释放资源退出程序
		jf.dispose();
		System.exit(0);
	}
}
