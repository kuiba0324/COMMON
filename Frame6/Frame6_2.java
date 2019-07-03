package COMMON.Frame6;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.WindowConstants;

import com.sun.awt.AWTUtilities;

public class Frame6_2 extends JFrame{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("程序启动");
		new Frame6_2();
	}
	public Frame6_2(){
		{
	        JLabel label=new JLabel("这是一个标签！");
	        label.setOpaque(false);
	        label.setHorizontalAlignment(JLabel.CENTER);
	        add(label);
	 
	        setSize(600,400);       
	 
	       setLocationRelativeTo(null);
	 
	        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	        setUndecorated(true);
	       //Opacity最大值为1.0f，也就是什么也不透明，取值不能大于1.0f
	        AWTUtilities.setWindowOpacity(this,0.5f);
	        setVisible(true);
	        
	    }
	  
	}

}
