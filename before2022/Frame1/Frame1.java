package COMMON.Frame1;
//���б���ͼƬ�Ĵ���,ͨ���÷�����ѧϰ��д���ֻ�ӭ����

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.MediaTracker;
import java.awt.Toolkit;
import java.net.URL;
//import javax.print.DocFlavor.URL;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JWindow;

public class Frame1 {
	static DemoWindow demo = null;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("����ʼ");
		demo = new DemoWindow();
		
	}

}

//���н������Ļ�ӭ������
/*
 * 1.Window ������һ��û�б߽�Ͳ˵����Ķ��㴰�ڡ����ڵ�Ĭ�ϲ����� BorderLayout
 * 2.JWindow ��һ��������������ʾ���û������ϵ��κ�λ�á� ��û�б����������ڹ���
 * ��ť���������� JFrame ���������Σ�������Ȼ���û�����ġ�һ����񡱣����Դ����������ϵ��κ�λ��
 * */
class DemoWindow extends JWindow implements Runnable{
	//������
	private JProgressBar progress = new JProgressBar();
	
	//ͼƬ���
	ImagePanel ip = new ImagePanel();
	//����Ӧ��ͼ��
	Image imageIcon = null;
	
	//���캯��
	public  DemoWindow (){
		add(ip,BorderLayout.CENTER);
		add(progress,BorderLayout.SOUTH);
		//���ý�����
		//�����Ƿ����ڽ���������ʾ����
		progress.setStringPainted(true);
		//�����Ƿ���ʾ�������߿�
		progress.setBorderPainted(true);
		//���ý������ϵ�����
		progress.setString("��������");
		progress.setForeground(Color.red);
		progress.setBackground(Color.white);
		//���ô�����
		this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
		//���ô���������ʾ����ͼƬ
		pack();
		//���ô��������ʾ
		Toolkit theKit = getToolkit();
		//Dimension ���װ��������������Ŀ�Ⱥ͸߶ȣ���ȷ��������
		Dimension wndSize = theKit.getScreenSize();
		this.setLocation((wndSize.width-ip.getWidth())/2,(wndSize.height-ip.getHeight())-50);
		//���ô���Ϊ�ɼ�
		this.setVisible(true);
		//����ǰ����������Ļ���д����ǰ��
		this.toFront();
		//�����ı���������߳�
		Thread splashThread = new Thread(this);
		//����Ӧ��ͼ��
		imageIcon = Toolkit.getDefaultToolkit().createImage("src/COMMON/Frame1/young7.png");
		if(imageIcon==null){
			System.out.println("ͼ��δ����");
		}else{
			System.out.println("�ɹ�����");
		}
		this.setIconImage(imageIcon);
		splashThread.start();
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try{
			//ѭ��һ�ٴ�
			for(int i=0;i<100;i++){
				Thread.sleep(100);
				progress.setValue(progress.getValue()+1);
			}
		}catch(Exception e){
			System.out.println(e.getMessage());
		}finally{
			//�ͷŴ�����Դ
			System.out.println("��Դ���ͷ�");
			//�ͷ��ɴ� Window�������������ӵ�е������������ʹ�õ����б�����Ļ��Դ
			this.dispose();
		}
	}
	
}

//ͼƬ���
class ImagePanel extends JPanel{
	//ͼƬ����
	Image image = null;
	
	//���캯��
	public ImagePanel(){
		//����MediaTracker��������Լ���ͼƬ�������Ա�֤ͼƬ������Ϻ�������һ������
		//https://blog.csdn.net/zhliro/article/details/45668117
		MediaTracker tracker = new MediaTracker(this);
		try{
			//����ͼƬ
			//ʹ�����·��ʱ��Ĭ�ϵ�ǰ·���ǹ���Ŀ¼��
			image = Toolkit.getDefaultToolkit().getImage("src/COMMON/Frame1/java.jpg");
			
			//����·��
			//image = Toolkit.getDefaultToolkit().getImage("E:/java.jpg");
			//�ȴ��������
			tracker.addImage(image, 0);
			tracker.waitForID(0);
			
			
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		//����ͼƬ���Ĵ�С������������ͼƬ
		this.setPreferredSize(new Dimension(image.getWidth(this),image.getHeight(this)));
	}
	@Override
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		g.drawImage(image,0,0,this);
	}
}