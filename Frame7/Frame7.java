package COMMON.Frame7;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;

//�Ӵ���

public class Frame7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DemoWindow demo = new DemoWindow("�Ӵ���");
	}


}

class DemoWindow extends JFrame implements ActionListener{
	JButton jb1 = new JButton("����");
	JButton jb2 = new JButton("����");
	JPanel jp = new JPanel();
	//�ܹ���ʾ�ڲ��Ӵ�������
	MultiWindowPanel mp = new MultiWindowPanel();
	public DemoWindow(String title){
		super(title);
		jp.setLayout(new FlowLayout());
		jp.add(jb1);
		jp.add(jb2);
		this.add(mp,BorderLayout.CENTER);
		this.add(jp,BorderLayout.SOUTH);
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setBounds(90,90,600,400);
		jb1.addActionListener(this);
		jb2.addActionListener(this);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==jb1){		//??
			mp.addInternalWindow();
		}else{
			mp.deleteInternalWindow();
		}
	}
	
	class MultiWindowPanel extends JPanel{
		//�ڲ��Ӵ�������
		JInternalFrame[] ip;		//https://blog.csdn.net/heimaoxiaozi/article/details/1499256
		//�����ڲ��Ӵ���������
		JDesktopPane dp = new JDesktopPane();
		//��ǰ�ڲ��Ӵ��������
		int index = 0;
		int number = 10;
		public MultiWindowPanel(){
			//�����ڲ��Ӵ�������
			ip = new JInternalFrame[number];
			
			setLayout(new BorderLayout());
			add(dp,BorderLayout.CENTER);
			
		}
		
		//�ú��������ڲ��Ӵ���
		public void addInternalWindow(){
			if(index < number){
				ip[index] = new JInternalFrame();
				ip[index].setSize(200, 200);
				ip[index].setLocation(index*20,index*20);
				ip[index].setResizable(true);	//�����Ƿ����ͨ��ĳ���û��������� JInternalFrame �Ĵ�С
				dp.add(ip[index],index);
				//��ʾ�ڲ��Ӵ���
				ip[index].setVisible(true);
				++index;
				
			}
		}
		
		//�ú���ɾ�����һ������ӵ��Ӵ���
		public void deleteInternalWindow(){
			if(index>0){
				--index;
				ip[index].setVisible(false);
			}else{
				
			}
		}
		
		
	}
	
}