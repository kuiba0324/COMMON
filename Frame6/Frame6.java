package COMMON.Frame6;

import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;


//透明窗体

public class Frame6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("程序开始");
		DemoWindow demo = new DemoWindow("透明窗体");
	}

}

class DemoWindow extends JFrame implements ChangeListener{
	//滑动条
	JSlider js =new JSlider(1,100);
	//布局面板
	JPanel jp = new JPanel();
	//演示文本标签
	JLabel jl = new JLabel("欢迎",JLabel.CENTER);
	public DemoWindow(String title){
		super(title);
		//设置标签字体
		jl.setFont(new Font("黑体",Font.BOLD,32));
		//设置滑动条初始值
		js.setValue(100);
		jp.add(js);
		this.add(jl,BorderLayout.CENTER);
		this.add(jp,BorderLayout.SOUTH);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		//添加事件监听器
		js.addChangeListener(this);
		this.setBounds(90,90,600,400);
		setUndecorated(true);			
		/*禁用或启用此窗体的装饰。只有在窗体不可显示时才调用此方法
		 * 这句代码必须放在setvisible之前
		 * - 如果窗体是可显示的,抛出IllegalComponentStateException异常
		*/
		this.setVisible(true);	
		/*
		 * --The following conditions must be met in order to set the opacity value less than 1.0f:
		 * 1.The TRANSLUCENT translucency must be supported by the underlying system
		 * 2.The window must be undecorated (see setUndecorated(boolean) and Dialog.setUndecorated(boolean))
		 * 3.The window must not be in full-screen mode (see GraphicsDevice.setFullScreenWindow(Window))
		 * If the requested opacity value is less than 1.0f, and any of the above conditions are not met, the window opacity 
		 * will not change， and the IllegalComponentStateException will be thrown.
		 * 
		 *设置setUndecorated()属性时，Frame的visible属性属性必须是false，所以该行代码必须在setVisible之前
		 */
		/*为什么用该段代替上面两行不行
		 * this.setVisible(true);	
		this.setVisible(false);
		setUndecorated(true);	
		this.setVisible(true);
		 * */	
		
		//JFrame.setDefaultLookAndFeelDecorated(true);
		System.out.println("调试输出1");
		
		
		
		
		
	}
	//响应动作
	@Override
	public void stateChanged(ChangeEvent e) {
		//设置窗体透明度
		com.sun.awt.AWTUtilities.setWindowOpacity(this, js.getValue()/100.0F);
	}		
	
	
}
