package COMMON.MouseLocation;
//��ȡ���λ��
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MainClass extends JFrame{
	static JLabel label = new JLabel("",JLabel.CENTER);
	static DrawPanel panel = new DrawPanel(label);
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//��̬�����У��������÷Ǿ�̬����
		MainClass m = new MainClass();
		m.add(panel);
		m.add(label,BorderLayout.SOUTH);
		
		System.out.println("����ʼ");
		m.setVisible(true);
		m.setSize(400,400);
		m.setDefaultCloseOperation(EXIT_ON_CLOSE);
		   
	}

}
class DrawPanel extends JPanel implements MouseMotionListener{
	JLabel label = new JLabel();
	DrawPanel(JLabel label){
		this.label = label;
		//label.setSize(10,10);  //��Ч?
		label.setOpaque(true);				
		/*
		 * ���Ϊ true��������������߽��ڵ��������ء������������ܲ����Ʋ��ֻ��������أ��Ӷ�������ײ�����͸�ӳ�����
		 * ���� JComponent ���ԣ������Ե�Ĭ��ֵ�� false�����Ƕ��ڴ������׼�� JComponent ���ࣨ�� JButton �� JTree��
		 * �������Ե�Ĭ��ֵ������й�
		 * isOpaque - ��������Ӧ���ǲ�͸���ģ���Ϊ true 
		 * */
		label.setBackground(Color.green);		//JLabel���ñ�����ɫ�����Ƚ�������Ϊ��͸���ģ���ΪĬ����͸���ġ���
		label.setForeground(Color.blue);
		label.setFont(new Font("Arial Bold",java.awt.Font.BOLD,45));
		this.addMouseMotionListener(this);
	}
	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		this.label.setText(e.getX()+","+e.getY());
		
	}
	

}

