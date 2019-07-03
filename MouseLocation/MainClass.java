package COMMON.MouseLocation;
//读取鼠标位置
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
		//静态方法中，不能引用非静态变量
		MainClass m = new MainClass();
		m.add(panel);
		m.add(label,BorderLayout.SOUTH);
		
		System.out.println("程序开始");
		m.setVisible(true);
		m.setSize(400,400);
		m.setDefaultCloseOperation(EXIT_ON_CLOSE);
		   
	}

}
class DrawPanel extends JPanel implements MouseMotionListener{
	JLabel label = new JLabel();
	DrawPanel(JLabel label){
		this.label = label;
		//label.setSize(10,10);  //无效?
		label.setOpaque(true);				
		/*
		 * 如果为 true，则该组件绘制其边界内的所有像素。否则该组件可能不绘制部分或所有像素，从而允许其底层像素透视出来。
		 * 对于 JComponent 而言，此属性的默认值是 false。但是对于大多数标准的 JComponent 子类（如 JButton 和 JTree）
		 * ，此属性的默认值与外观有关
		 * isOpaque - 如果此组件应该是不透明的，则为 true 
		 * */
		label.setBackground(Color.green);		//JLabel设置背景颜色必须先将它设置为不透明的，因为默认是透明的。。
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

