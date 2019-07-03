package COMMON.KeyBoard_Entry;

import java.awt.Robot;

/*
 * 测试Runtime.getRuntime().exec(String)的用法
 * 
 * */


public class TestClass1 {
	public static void main(String[] args){
		System.out.println("程序开始");
		try {
			//java.awt.Robot robot = new Robot();
			//java.lang.Runtime.getRuntime().exec("cmd /c start D:\\网易云\\CloudMusic\\cloudmusic.exe");
			java.lang.Runtime.getRuntime().exec("cmd /c D:\\网易云\\CloudMusic\\cloudmusic.exe"); // /C的作用：https://blog.csdn.net/mp624183768/article/details/88390665
			//robot.delay(10000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
