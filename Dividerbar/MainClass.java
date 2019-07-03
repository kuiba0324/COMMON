package COMMON.Dividerbar;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;
import javax.swing.text.PlainDocument;

//���зָ����Ĵ���

public class MainClass {

	public static void main(String[] args) {
		System.out.println("����ʼ");
		DemoWindow demo = new DemoWindow("demo");
		demo.setVisible(true);
		demo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		demo.setBounds(100,100,600,400);
		// TODO Auto-generated me thod stub
		
	}

}

class DemoWindow extends JFrame implements ActionListener{
	//���зָ��������
	SplitJPanel sp = new SplitJPanel();
	//������ť
	JButton jb = new JButton("��ʾ�ָ���");
	public DemoWindow(String title){
		super(title);
		this.add(sp,BorderLayout.CENTER);
		this.add(jb,BorderLayout.SOUTH);
		jb.addActionListener(this);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		JButton jb = (JButton)e.getSource();
		if(jb.getText().equals("��ʾ�ָ���")){
			jb.setText("���طָ���");
			sp.activate();
		}else{
			jb.setText("��ʾ�ָ���");
			sp.deactivate();
		}
	}
	
}
//���зָ����������
class SplitJPanel extends JPanel{
	//�����ı�������ĵ�ģ��
	PlainDocument pd = new PlainDocument();		//PlainDocument?
	//��һ���ı���
	JTextArea jtf1 = new JTextArea(pd);			//JTextArea?
	//�ڶ����ı���
	JTextArea jtf2 = new JTextArea(pd);
	//�ָ���
	JSplitPane jsp = null;
	public SplitJPanel(){
		this.setLayout(new BorderLayout());
		this.add(jtf1);
	}
	//��ʾ�ָ���
	public void activate(){
		//ȡ����һ�ı������ʾ
		this.remove(jtf1);
		//���طָ����ָ��������ı���
		jsp = new JSplitPane(JSplitPane.VERTICAL_SPLIT,jtf1,jtf2);
		//����ָ����ṩС����������չ�������۵�
		jsp.setOneTouchExpandable(true);
		//���÷ָ����ķָʽΪ��ֱ�ָ�
		jsp.setOrientation(JSplitPane.VERTICAL_SPLIT);
		//���طָ���
		this.add(jsp,BorderLayout.CENTER);
		//ˢ�´���				
		this.revalidate();		//https://blog.csdn.net/yinyinliushang/article/details/84420510
								//https://blog.csdn.net/xd5250203/article/details/4802240
		/*invalidate()�Ǳ�����Ϊ��Ч����Ҫ�����²��֡�
		 * validate()�������е�����������²��֡�
		 * revalidate()���齨��־Ϊ��Ч�������齨��νṹ�еĵ�һ������
		 * ��һ����panel)���¼��ɷ��߳���ִ��validate().*/
	}
	//��ʾ��һ�ı���
	public void deactivate(){
		//���طָ���
		this.remove(jsp);
		//�����ı���
		this.add(jtf1,BorderLayout.CENTER);
		//ˢ�´���
		this.revalidate();
	}
}



