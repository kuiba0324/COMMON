package COMMON.Frame1;
//带有背景图片的窗体,通过该范例，学习编写各种欢迎窗体

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
		System.out.println("程序开始");
		demo = new DemoWindow();
		
	}

}

//带有进度条的欢迎窗体类
/*
 * 1.Window 对象是一个没有边界和菜单栏的顶层窗口。窗口的默认布局是 BorderLayout
 * 2.JWindow 是一个容器，可以显示在用户桌面上的任何位置。 它没有标题栏、窗口管理
 * 按钮或者其他与 JFrame 关联的修饰，但它仍然是用户桌面的“一类居民”，可以存在于桌面上的任何位置
 * */
class DemoWindow extends JWindow implements Runnable{
	//进度条
	private JProgressBar progress = new JProgressBar();
	
	//图片面板
	ImagePanel ip = new ImagePanel();
	//设置应用图标
	Image imageIcon = null;
	
	//构造函数
	public  DemoWindow (){
		add(ip,BorderLayout.CENTER);
		add(progress,BorderLayout.SOUTH);
		//设置进度条
		//设置是否能在进度条上显示字样
		progress.setStringPainted(true);
		//设置是否显示进度条边框
		progress.setBorderPainted(true);
		//设置进度条上的字样
		progress.setString("正在启动");
		progress.setForeground(Color.red);
		progress.setBackground(Color.white);
		//设置窗体光标
		this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
		//设置窗体正好显示整个图片
		pack();
		//设置窗体居中显示
		Toolkit theKit = getToolkit();
		//Dimension 类封装单个对象中组件的宽度和高度（精确到整数）
		Dimension wndSize = theKit.getScreenSize();
		this.setLocation((wndSize.width-ip.getWidth())/2,(wndSize.height-ip.getHeight())-50);
		//设置窗体为可见
		this.setVisible(true);
		//将当前窗体至于屏幕所有窗体的前面
		this.toFront();
		//启动改变进程条的线程
		Thread splashThread = new Thread(this);
		//设置应用图标
		imageIcon = Toolkit.getDefaultToolkit().createImage("src/COMMON/Frame1/young7.png");
		if(imageIcon==null){
			System.out.println("图标未加载");
		}else{
			System.out.println("成功加载");
		}
		this.setIconImage(imageIcon);
		splashThread.start();
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try{
			//循环一百次
			for(int i=0;i<100;i++){
				Thread.sleep(100);
				progress.setValue(progress.getValue()+1);
			}
		}catch(Exception e){
			System.out.println(e.getMessage());
		}finally{
			//释放窗体资源
			System.out.println("资源已释放");
			//释放由此 Window、其子组件及其拥有的所有子组件所使用的所有本机屏幕资源
			this.dispose();
		}
	}
	
}

//图片面板
class ImagePanel extends JPanel{
	//图片内容
	Image image = null;
	
	//构造函数
	public ImagePanel(){
		//创建MediaTracker类变量，以加载图片，他可以保证图片加载完毕后会进行下一步操作
		//https://blog.csdn.net/zhliro/article/details/45668117
		MediaTracker tracker = new MediaTracker(this);
		try{
			//加载图片
			//使用相对路径时，默认当前路径是工程目录下
			image = Toolkit.getDefaultToolkit().getImage("src/COMMON/Frame1/java.jpg");
			
			//绝对路径
			//image = Toolkit.getDefaultToolkit().getImage("E:/java.jpg");
			//等待加载完毕
			tracker.addImage(image, 0);
			tracker.waitForID(0);
			
			
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		//设置图片面板的大小正好容纳整个图片
		this.setPreferredSize(new Dimension(image.getWidth(this),image.getHeight(this)));
	}
	@Override
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		g.drawImage(image,0,0,this);
	}
}