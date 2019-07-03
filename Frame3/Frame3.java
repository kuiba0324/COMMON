package COMMON.Frame3;

import java.awt.Graphics;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Frame3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("程序开始");
		DemoWindow demo = new DemoWindow("拉伸图片的窗体背景");
		demo.setVisible(true);
		demo.setLocation(50,50);
		demo.setSize(700,500);
		demo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		System.out.println("程序结束");
	}

}
//界面窗体
class DemoWindow extends JFrame{
	public DemoWindow(String title){
		super(title);
		add(new ImagePanel());
	}
}

class ImagePanel extends JPanel{
	//图片地址
	URL imgURL = this.getClass().getResource("java.jpg");
	
	//重写绘图函数
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		System.out.println(imgURL);
		//绘制拉伸图片背景
		ImageIcon icon = new ImageIcon(imgURL);			//ImageIcon??		https://blog.csdn.net/fly_china2008/article/details/6102544
		g.drawImage(icon.getImage(), 0, 0, this.getSize().width, this.getSize().height, this);  
									//此处的0，0指的是从程序窗体开始据
		
	}
}