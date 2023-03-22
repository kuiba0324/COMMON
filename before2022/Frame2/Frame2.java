package COMMON.Frame2;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

//ƽ��ͼƬ�Ĵ��屳��
public class Frame2 {

	public static void main(String[] args){
		System.out.println("����ʼ");
		DemoWindow demo = new DemoWindow("��ʾ����");
		demo.setLocation(new Point(300,300));
		demo.setSize(500, 400);
		demo.setVisible(true);
		demo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		//Ϊʲô�˴��޷������ر�
		System.out.println("�������");
	}
}

//���洰��
class DemoWindow extends JFrame{
	public DemoWindow(String title){
		super(title);
		//�����ܹ�ƽ�̱���ͼƬ�����
		add(new ImagePanel());
		Image imageicon = Toolkit.getDefaultToolkit().createImage("src/COMMON/Frame2/young7.png");
		if(imageicon==null){
			System.out.println("ͼ��δ����");
		}else{
			System.out.println("ͼ��ɹ�����");
		}
		this.setIconImage(imageicon);
	}
}

//ƽ�̱���ͼƬ�����
class ImagePanel extends JPanel{
	//ͼƬ·��
	//URL imageURL = this.getClass().getResource("E:/Myeclipseworkplace/CommonProject/src/COMMON/Frame2/java.jpg");		//��������Ϊ����·����
	URL imageURL = this.getClass().getResource("java.jpg");	//Ĭ��·���ǵ�ǰ��
	//��д��ͼ����������ƽ��ͼƬ
	public void paintComponent(Graphics g){		//?
		super.paintComponent(g);
		if(imageURL == null){
			System.out.println("ͼƬ·��δ��ȷ����");
		}
		//����ƽ��ͼƬ����
		ImageIcon icon = new ImageIcon(imageURL);
		if(icon != null){
			System.out.println("ͼƬ·���ɹ�����");
		}
		//ÿһ��ͼ���λ������
		int x=0;
		int y = 0;
		//ƽ�̱���ͼƬ
		while(true){
			//����ͼƬ
			g.drawImage(icon.getImage(), x, y,this);		//��
			
			if(x>this.getSize().width&&y>this.getSize().height){
				break;
				
			}
			
			if(x>this.getSize().width){
				x = 0;
				y += icon.getIconHeight();
				
			}
			//����ڵ�ǰ�У��ĵ���һ��ͼ���λ��
			else{
				x += icon.getIconWidth();
			}
		}
		
	}
	
}