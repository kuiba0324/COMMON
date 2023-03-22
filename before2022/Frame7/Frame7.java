package COMMON.Frame7;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;

//子窗体

public class Frame7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DemoWindow demo = new DemoWindow("子窗体");
	}


}

class DemoWindow extends JFrame implements ActionListener{
	JButton jb1 = new JButton("增加");
	JButton jb2 = new JButton("减少");
	JPanel jp = new JPanel();
	//能够显示内部子窗体的面板
	MultiWindowPanel mp = new MultiWindowPanel();
	public DemoWindow(String title){
		super(title);
		jp.setLayout(new FlowLayout());
		jp.add(jb1);
		jp.add(jb2);
		this.add(mp,BorderLayout.CENTER);
		this.add(jp,BorderLayout.SOUTH);
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setBounds(90,90,600,400);
		jb1.addActionListener(this);
		jb2.addActionListener(this);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==jb1){		//??
			mp.addInternalWindow();
		}else{
			mp.deleteInternalWindow();
		}
	}
	
	class MultiWindowPanel extends JPanel{
		//内部子窗体数组
		JInternalFrame[] ip;		//https://blog.csdn.net/heimaoxiaozi/article/details/1499256
		//容纳内部子窗体的桌面版
		JDesktopPane dp = new JDesktopPane();
		//当前内部子窗体的数量
		int index = 0;
		int number = 10;
		public MultiWindowPanel(){
			//创建内部子窗体数组
			ip = new JInternalFrame[number];
			
			setLayout(new BorderLayout());
			add(dp,BorderLayout.CENTER);
			
		}
		
		//该函数增加内部子窗体
		public void addInternalWindow(){
			if(index < number){
				ip[index] = new JInternalFrame();
				ip[index].setSize(200, 200);
				ip[index].setLocation(index*20,index*20);
				ip[index].setResizable(true);	//设置是否可以通过某个用户操作调整 JInternalFrame 的大小
				dp.add(ip[index],index);
				//显示内部子窗体
				ip[index].setVisible(true);
				++index;
				
			}
		}
		
		//该函数删除最后一个被添加的子窗体
		public void deleteInternalWindow(){
			if(index>0){
				--index;
				ip[index].setVisible(false);
			}else{
				
			}
		}
		
		
	}
	
}