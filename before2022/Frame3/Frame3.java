package COMMON.Frame3;

import java.awt.Graphics;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Frame3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("����ʼ");
		DemoWindow demo = new DemoWindow("����ͼƬ�Ĵ��屳��");
		demo.setVisible(true);
		demo.setLocation(50,50);
		demo.setSize(700,500);
		demo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		System.out.println("�������");
	}

}
//���洰��
class DemoWindow extends JFrame{
	public DemoWindow(String title){
		super(title);
		add(new ImagePanel());
	}
}

class ImagePanel extends JPanel{
	//ͼƬ��ַ
	URL imgURL = this.getClass().getResource("java.jpg");
	
	//��д��ͼ����
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		System.out.println(imgURL);
		//��������ͼƬ����
		ImageIcon icon = new ImageIcon(imgURL);			//ImageIcon??		https://blog.csdn.net/fly_china2008/article/details/6102544
		g.drawImage(icon.getImage(), 0, 0, this.getSize().width, this.getSize().height, this);  
									//�˴���0��0ָ���Ǵӳ����忪ʼ��
		
	}
}