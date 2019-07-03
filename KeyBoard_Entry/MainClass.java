package COMMON.KeyBoard_Entry;
/*
 * 本范例演示了自动打开 记事本程序，自动录入键盘字符的效果
 * 重点注意Robot类的使用
 * 
 * */
 import java.awt.Robot;
 import java.awt.event.KeyEvent;
public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("程序开始");
		try{
			//创建自动操作类
			Robot robot = new Robot();
			//启动记事本程序
			Runtime.getRuntime().exec("cmd /c start notepad");
			
			//延迟五秒，等待记事本启动成功
			robot.delay(3000);
			//模拟按下ctrl+space键，启动输入法  （是否所有电脑的启动输入法都是CTRL+space)
			pressKeyWithCtrl(robot,KeyEvent.VK_SPACE);
			//模拟按下shift，切换输入法为中文
			pressKeyOfShift(robot);
			//模拟随机按下100个字母，输入汉字
			for(int i =0;i<100;i++){
				pressKey(robot,(int)(Math.random()*25)+'A');
				pressKey(robot,KeyEvent.VK_SPACE);
			}
			//延缓五秒钟以供观察
			robot.delay(3000);
			//关闭记事本
			closeApplication(robot);
		}catch(Exception E){
			E.printStackTrace();
		}
	}
	public static void pressKeyOfShift(Robot robot){
		robot.keyPress(KeyEvent.VK_SHIFT);
		robot.keyRelease(KeyEvent.VK_SHIFT);
	}
	public static void pressKey(Robot robot,int keyValue){
		//模拟按下
		robot.keyPress(keyValue);
		//模拟弹起
		robot.keyRelease(keyValue);
	}
	
	//模拟同时按下Ctrl+字符、键的方法
	public static void pressKeyWithCtrl(Robot robot,int keyValue){
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(keyValue);
		
		robot.keyRelease(keyValue);
		robot.keyRelease(KeyEvent.VK_CONTROL);
	}
	
	public static void closeApplication(Robot robot){
		robot.keyPress(KeyEvent.VK_ALT);
		robot.keyPress(KeyEvent.VK_F4);
		//此处调换下方VK_ALT和VK_F4的值是否有影响
		robot.keyRelease(KeyEvent.VK_ALT);
		robot.keyRelease(KeyEvent.VK_F4);
		//模拟按下N键，不保存文件退出记事本
		robot.keyPress(KeyEvent.VK_N);
		robot.keyRelease(KeyEvent.VK_N);
		
	}

}
