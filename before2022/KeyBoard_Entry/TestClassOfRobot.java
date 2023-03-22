package COMMON.KeyBoard_Entry;

import java.awt.Robot;

/*
 * 关于robot的测试类
 * 此类用于为测试自动化、自运行演示程序和其他需要控制鼠标和键盘的应用程序生成本机系统输入事件。Robot 的主要目的是便于 Java 平台实现自动测试。
 *  使用该类生成输入事件与将事件发送到 AWT 事件队列或 AWT 组件的区别在于：事件是在平台的本机输入队列中生成的。例如，Robot.mouseMove 将实际移动鼠标光标，而不是只生成鼠标移动事件。
 *  注意，某些平台需要特定权限或扩展来访问低级输入控件。如果当前平台配置不允许使用输入控件，那么试图构造 Rob00000000000000000000000000000000ot 对象时将抛出 AWTException。
 *  例如，如果 X 服务器不支持（或没有启用）XTEST 2.2 标准扩展，则 X-Window 系统会抛出异常。
 *  出于自测试之外的目的而使用 Robot 的应用程序应妥善处理这些错误条件。 
 *  
 *  --摘自：http://tool.oschina.net/apidocs/apidoc?api=jdk-zh
 * */
public class TestClassOfRobot {
	public static void main(String[] args){
		System.out.println("程序开始");
		try {
			java.awt.Robot robot = new Robot();
			robot.delay(3000);
			robot.mouseMove(800, 409);
			robot.mouseWheel(10);
			robot.mousePress(java.awt.event.InputEvent.BUTTON1_MASK);
			robot.mouseRelease(java.awt.event.InputEvent.BUTTON1_MASK);
		
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			System.out.println("程序结束");
		}
	}
}
