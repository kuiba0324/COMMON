package COMMON.Frame5;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

//���б���߿�Ĵ���
public class Frame5 {
	public static void main(String args[]){
		System.out.println("Frame5����ʼ");
		 DemoWindow demo = new DemoWindow("ʾ������");
		 
	}
}
 
class DemoWindow extends JFrame{
	//����߿����
	JPanel jp = new JPanel();
	public DemoWindow (String title){
		super(title);
		//�������б���ı߿�
		TitledBorder td = BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.white),"��ʾ����");
		//���ñ���߿�ı�����뷽ʽ����ɫ
		td.setTitleJustification(TitledBorder.CENTER);
		td.setTitleColor(Color.yellow);
		//����͹��߿�
		Border border2 = BorderFactory.createEtchedBorder(EtchedBorder.RAISED);
		//�������ϱ߿�,������߿��͹��߿��������
		Border newBorder = BorderFactory.createCompoundBorder(td,border2);
		//�������ı߿�
		jp.setBorder(newBorder);
		//������屳��ɫ
		jp.setBackground(Color.gray);
		//���������ʾһ����ɫ���������
		jp.setLayout(new BorderLayout());
		jp.add(new JPanel());
		add(jp);
		this.setBounds(69, 88, 800, 600);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	
}