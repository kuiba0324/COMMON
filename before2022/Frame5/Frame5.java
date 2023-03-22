package COMMON.Frame5;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

//带有标题边框的窗体
public class Frame5 {
	public static void main(String args[]){
		System.out.println("Frame5程序开始");
		 DemoWindow demo = new DemoWindow("示例窗口");
		 
	}
}
 
class DemoWindow extends JFrame{
	//标题边框面板
	JPanel jp = new JPanel();
	public DemoWindow (String title){
		super(title);
		//创建带有标题的边框
		TitledBorder td = BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.white),"显示区域");
		//设置标题边框的标题对齐方式和颜色
		td.setTitleJustification(TitledBorder.CENTER);
		td.setTitleColor(Color.yellow);
		//创建凸起边框
		Border border2 = BorderFactory.createEtchedBorder(EtchedBorder.RAISED);
		//创建复合边框,将标题边框和凸起边框组合起来
		Border newBorder = BorderFactory.createCompoundBorder(td,border2);
		//设置面板的边框
		jp.setBorder(newBorder);
		//设置面板背景色
		jp.setBackground(Color.gray);
		//在面板中显示一个灰色的正常面板
		jp.setLayout(new BorderLayout());
		jp.add(new JPanel());
		add(jp);
		this.setBounds(69, 88, 800, 600);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	
}