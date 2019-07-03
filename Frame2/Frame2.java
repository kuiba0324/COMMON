package COMMON.Frame2;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

//平铺图片的窗体背景
public class Frame2 {

	public static void main(String[] args){
		System.out.println("程序开始");
		DemoWindow demo = new DemoWindow("演示窗体");
		demo.setLocation(new Point(300,300));
		demo.setSize(500, 400);
		demo.setVisible(true);
		demo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		//为什么此处无法正常关闭
		System.out.println("程序结束");
	}
}

//界面窗体
class DemoWindow extends JFrame{
	public DemoWindow(String title){
		super(title);
		//加载能够平铺背景图片的面板
		add(new ImagePanel());
		Image imageicon = Toolkit.getDefaultToolkit().createImage("src/COMMON/Frame2/young7.png");
		if(imageicon==null){
			System.out.println("图标未加载");
		}else{
			System.out.println("图标成功加载");
		}
		this.setIconImage(imageicon);
	}
}

//平铺背景图片面板类
class ImagePanel extends JPanel{
	//图片路径
	//URL imageURL = this.getClass().getResource("E:/Myeclipseworkplace/CommonProject/src/COMMON/Frame2/java.jpg");		//不可设置为绝对路径？
	URL imageURL = this.getClass().getResource("java.jpg");	//默认路径是当前包
	//重写绘图函数，绘制平铺图片
	public void paintComponent(Graphics g){		//?
		super.paintComponent(g);
		if(imageURL == null){
			System.out.println("图片路径未正确设置");
		}
		//绘制平铺图片背景
		ImageIcon icon = new ImageIcon(imageURL);
		if(icon != null){
			System.out.println("图片路径成功加载");
		}
		//每一幅图像的位置坐标
		int x=0;
		int y = 0;
		//平铺背景图片
		while(true){
			//绘制图片
			g.drawImage(icon.getImage(), x, y,this);		//？
			
			if(x>this.getSize().width&&y>this.getSize().height){
				break;
				
			}
			
			if(x>this.getSize().width){
				x = 0;
				y += icon.getIconHeight();
				
			}
			//如果在当前行，的到下一个图标的位置
			else{
				x += icon.getIconWidth();
			}
		}
		
	}
	
}