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

//带有分隔栏的窗体

public class MainClass {

	public static void main(String[] args) {
		System.out.println("程序开始");
		DemoWindow demo = new DemoWindow("demo");
		demo.setVisible(true);
		demo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		demo.setBounds(100,100,600,400);
		// TODO Auto-generated me thod stub
		
	}

}

class DemoWindow extends JFrame implements ActionListener{
	//带有分隔栏的面板
	SplitJPanel sp = new SplitJPanel();
	//操作按钮
	JButton jb = new JButton("显示分隔栏");
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
		if(jb.getText().equals("显示分隔栏")){
			jb.setText("隐藏分隔栏");
			sp.activate();
		}else{
			jb.setText("显示分隔栏");
			sp.deactivate();
		}
	}
	
}
//带有分隔栏的面板类
class SplitJPanel extends JPanel{
	//两个文本框共享的文档模型
	PlainDocument pd = new PlainDocument();		//PlainDocument?
	//第一个文本区
	JTextArea jtf1 = new JTextArea(pd);			//JTextArea?
	//第二个文本区
	JTextArea jtf2 = new JTextArea(pd);
	//分隔栏
	JSplitPane jsp = null;
	public SplitJPanel(){
		this.setLayout(new BorderLayout());
		this.add(jtf1);
	}
	//显示分隔栏
	public void activate(){
		//取消单一文本框的显示
		this.remove(jtf1);
		//加载分隔栏分隔的两个文本区
		jsp = new JSplitPane(JSplitPane.VERTICAL_SPLIT,jtf1,jtf2);
		//允许分割条提供小部件来快速展开或者折叠
		jsp.setOneTouchExpandable(true);
		//设置分隔栏的分割方式为垂直分割
		jsp.setOrientation(JSplitPane.VERTICAL_SPLIT);
		//加载分隔栏
		this.add(jsp,BorderLayout.CENTER);
		//刷新窗体				
		this.revalidate();		//https://blog.csdn.net/yinyinliushang/article/details/84420510
								//https://blog.csdn.net/xd5250203/article/details/4802240
		/*invalidate()是标记组件为无效，需要被重新布局。
		 * validate()将容器中的所有组件重新布局。
		 * revalidate()将组建标志为无效，并将组建层次结构中的第一个容器
		 * （一般是panel)在事件派发线程上执行validate().*/
	}
	//显示单一文本区
	public void deactivate(){
		//隐藏分隔栏
		this.remove(jsp);
		//加载文本区
		this.add(jtf1,BorderLayout.CENTER);
		//刷新窗体
		this.revalidate();
	}
}



