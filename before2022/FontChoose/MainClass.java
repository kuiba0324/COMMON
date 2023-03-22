package COMMON.FontChoose;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.GraphicsEnvironment;
import java.awt.Panel;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

//字体选择窗体

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("程序开始");
		DemoWindow demo = new DemoWindow("demo");
		demo.setVisible(true);
		demo.setBounds(100,100,600,400);
		demo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}

class DemoWindow extends JFrame implements ItemListener{
	//提示标签
	JLabel TYPEFACE = new JLabel("字体");
	JLabel SIZE = new JLabel("大小");
	JLabel TYPE = new JLabel("样式");
	//字体名称组合框
	JComboBox jcb1 = null;		//JComboBox
	//字体大小组合框
	JComboBox jcb2 = null;
	//字体样式组合框
	JComboBox jcb3 = null;
	
	JPanel jp = new JPanel();
	
	//演示字体效果的面板
	FontPanel fp = new FontPanel();
	//字体名称
	String fontName = null;
	//字体大小
	int fontSize = 10;
	//字体样式
	int fontStyle = 0;
	
	public DemoWindow(String title){
		super(title);
		//获取系统字体名称
		GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();			//GraphicsEnvironment
		String[] sysFonts = ge.getAvailableFontFamilyNames();
		//创建字体名称组合框
		jcb1 = new JComboBox(sysFonts);		
		//设置默认选择的字体名称
		fontName = sysFonts[0];
		
		//创建字体大小字符串数组
		String[] fontSizes = new String[10];
		for(int i=0;i<fontSizes.length;i++){
			fontSizes[i] = String.valueOf(10+i*10);
			
		}
		//创建字体大小组合框
		jcb2 = new JComboBox(fontSizes);
		
		//创建字体样式组合框
		jcb3 = new JComboBox(new String[]{
				"PLAIN","BOLD","ITALIC","BOLD&ITALIC"
		});
		
		jp.setLayout(new FlowLayout());
		jp.add(TYPEFACE);
		jp.add(jcb1);
		jp.add(SIZE);
		jp.add(jcb3);
		jp.add(TYPE);
		jp.add(jcb2);
		
		this.add(jp,BorderLayout.NORTH);
		add(fp,BorderLayout.CENTER);
		jcb1.addItemListener(this);
		jcb2.addItemListener(this);
		jcb3.addItemListener(this);
		
		//设置最佳尺寸
		this.setPreferredSize(new Dimension(600,200));		//??
	}
	
	
	@Override
	public void itemStateChanged(ItemEvent e) {			//itemStateChanged
		// TODO Auto-generated method stub 
		System.out.println("itemStateChanged方法调用");
		if(e.getStateChange() == ItemEvent.SELECTED){
			Object list = e.getSource();
			//处理选择字体的名称
			if(list == jcb1){
				fontName = (String)jcb1.getSelectedItem();
			}
			//处理选择字体大小
			else if(list == jcb2){
				String sizeString = (String)jcb2.getSelectedItem();
				fontSize = Integer.parseInt(sizeString);
				
			}
			//处理选择字体的样式
			else{
				fontStyle = jcb3.getSelectedIndex();
				
			}
			//设置新的字体
			fp.setFont(fontName,fontStyle,fontSize);
			
		}
	}
	
}

class FontPanel extends JPanel{
	//演示文本
	String demoString = "java";
	//字体
	Font font = new Font("Arial",Font.PLAIN,40);
	//字体的设置函数
	public void setFont(String f,int st,int size){
		font = new Font(f,st,size);
		repaint();
		
	}
	//字体读取函数
	public Font getFont(){
		return this.font;
	}
	
	//重载绘图函数
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		//获取当前面板的宽度和高度
		int width = this.getWidth();
		int height = this.getHeight();
		//设置颜色
		this.setBackground(Color.blue);
		g.setColor(Color.darkGray);
		//设置绘图字体
		g.setFont(font);
		//居中绘制演示文本
		FontMetrics metrics = g.getFontMetrics();   		//FontMetrics 类定义字体规格对象，该对象封装将在特定屏幕上呈现特定字体的有关信息
		int wid = metrics.stringWidth(demoString);
		int hei = metrics.getAscent();		//在获取高度的时候不建议使用metrics.getHeight方法，他是指相邻文本行字基线之间的距离，通常大于字符真正的高度
		g.drawString(demoString, width/2-wid/2, height/2+hei/2);
		
	}
}