package COMMON.KeyBoard_Entry;

import java.awt.Robot;

/*
 * ����Runtime.getRuntime().exec(String)���÷�
 * 
 * */


public class TestClass1 {
	public static void main(String[] args){
		System.out.println("����ʼ");
		try {
			//java.awt.Robot robot = new Robot();
			//java.lang.Runtime.getRuntime().exec("cmd /c start D:\\������\\CloudMusic\\cloudmusic.exe");
			java.lang.Runtime.getRuntime().exec("cmd /c D:\\������\\CloudMusic\\cloudmusic.exe"); // /C�����ã�https://blog.csdn.net/mp624183768/article/details/88390665
			//robot.delay(10000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
