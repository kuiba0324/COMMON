package COMMON.ThirdPackage;
//本范例演示了使用掩码格式类MaskFormatter验证以及限制文本框输入信息的方法，该文本框只允许输入8个数字字符
/*
 * 	#	任何有效数字
 * 	'	转义字符，用于避开任何有特殊意义的字符
 * 	U	任何字符，将小写字符映射为大写
 * 	L	任何字符，将大写映射为小写
 * 	A	任何字符或数字
 * 	?	任何字符
 * 	*	所有字符
 * 	H	任何十六进制字符（0-9，a-z，A-Z）
 * */


import java.awt.FlowLayout;
import java.awt.Point;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

public class Window extends JFrame{
	JTextField jtf = null;
	//掩码格式类
	MaskFormatter format  = null;
	//Class3 cl3 = new Class3();
	public Window(){
		super("文本框");
		this.DO();
		this.setLocation(new Point(800,400));
		this.setSize(300, 100);
		this.setAlwaysOnTop(isAlwaysOnTop());
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE); //设置关闭方式 如果不设置的话 似乎关闭窗口之后不会退出程序
	}
	public void DO(){
		System.out.println("DO方法开始");
	
		//创建掩码格式类变量
		try{
			format = new MaskFormatter("########");
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		jtf = new JFormattedTextField(format);
		jtf.setColumns(8);
		this.setLayout(new FlowLayout());
		this.add(jtf);
		
		System.out.println("DO方法结束");
	}
}
