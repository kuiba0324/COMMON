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

//�����Ĵ�����������

public class MainClass {
	public static void main(String[] args){
		System.out.println("����ʼ");
		MyFrame myframe = new MyFrame();
	}
}

class MyFrame extends JFrame{
	public MyFrame(){
		//���ô������
		this.setTitle("demo");
		setBackground(Color.white);
		//���ô�������ߴ����Ӧλ��
		Rectangle bounds = new Rectangle(100,100,100,100);		//Rectangle;
		this.setMaximizedBounds(bounds);
		Toolkit thekit =  this.getToolkit();
		Dimension demoSize = thekit.getScreenSize();
		setBounds(demoSize.width/3,demoSize.height/3,demoSize.width/3,demoSize.height/3);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		//���ô���ͼ��
		Image icon = Toolkit.getDefaultToolkit().getImage("src/COMMON/FrameProrerty/java.jpg");
		//Image icon = Toolkit.getDefaultToolkit().getImage("src/COMMON/FrameProrerty/young7.png");
		if(icon != null){
			System.out.println("�ǿ�");
		}
		this.setIconImage(icon);
		//���ô�����
		this.setCursor(Cursor.TEXT_CURSOR);
		//���ô����޷���С��
		this.addWindowListener(new WindowAdapter(){				
			public void windowIconified(WindowEvent e){	//������ͼ�껯ʱ����
				setState(Frame.NORMAL);
			}
		});
		
		this.setVisible(true);
		
		
	}
}
