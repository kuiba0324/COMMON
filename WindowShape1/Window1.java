package COMMON.WindowShape1;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.geom.Ellipse2D;
import javax.swing.JFrame;
import com.sun.awt.AWTUtilities;		
/*com.sun.awt.AWTUtilities需要额外导入rt.jar,
步骤如下	https://blog.csdn.net/aigochina/article/details/8236072
遗憾的是，加入了该包后，程序就不具有跨平台性了，因为以com.sun/sun开头的是属于非公开/为了实现jre的、没
有后续保证，即未包括在发布的JDK中.如果要具有跨平台性，可以使用第三方jar包，如使用 jna.jar + platform.jar 提供的WindowUtils类
*/


//窗体外观特效
//不规则窗体
public class Window1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("程序开始");
		//设置是否允许窗体的观感装饰,JFrame 将具有当前窗口管理器为其提供的 Window 装饰
		JFrame.setDefaultLookAndFeelDecorated(true);		//https://blog.csdn.net/sunyiz/article/details/7595371
		//设置窗体类变量
		JFrame jf = new JFrame("不规则窗体");
		//将窗体的宽度和高度分别设置为屏幕的三分之一
		//左上角位置也设置为屏幕的宽高的三分之一
		Toolkit thekit = jf.getToolkit();
		Dimension wndSize = thekit.getScreenSize();
		jf.setBounds(wndSize.width/3,wndSize.height/3,wndSize.width/4,wndSize.height/4);
		//设置窗体外形为圆形
		AWTUtilities.setWindowShape(jf,new Ellipse2D.Double(0,0,jf.getWidth(),jf.getHeight()));
		
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//设置窗体可见
		jf.setVisible(true);
		
	}

}
