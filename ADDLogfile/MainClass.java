package COMMON.ADDLogfile;

import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("程序开始");
		LoggingClass log1 = new LoggingClass();
		log1.badMethod();
	}

}
class LoggingClass{
	//声明日志记录变量
	Logger logger;
	LoggingClass(){
		try{
			//打开指定文件   true表示允许追加
			FileHandler fh = new FileHandler("info.log",true);	//该构造函数默认指定的地址在哪里
			//利用工厂方法getLogger获得logger对象，logger的名称是LoggingClass
			//logger = Logger.getLogger("LoggingClass");			//COMMON.ADDLogfile.LoggingClass badMethod
			//logger = Logger.getLogger("");	//java.util.logging.LogManager$RootLogger log
			/*
			 * 总是存在一个rootLogger，即使没有显示配置也是存在的，并且默认输出级别为DEBUG
			 * 所有其他的Logger都默认继承自rootLogger 
			 * 2 自定义的Logger（子Loggger）继承自rootLogger
			 * 格式如下： [quote]log4j.logger.A.B.C[/quote]
			 * 这样定义后其实建立了3个logger实例，它们分别是"A"、"A.B"、"A.B.C"。每次我们在系统中取得logger时，
			 * 并不是新建实例，这些实例是系统启动的时候就按照配置文件初始化好的（也可能时第一次引用的时候建立的，然后缓存其实例供以后使用，
			 * 这部分还没有时间研究）。
			 * 
			 */
			//logger = Logger.getLogger("w");	//COMMON.ADDLogfile.LoggingClass badMethod
			logger = Logger.getLogger(" ");		//COMMON.ADDLogfile.LoggingClass badMethod
			//添加一个日志处理项以记录日志信息
			logger.addHandler(fh);
			
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
	public void badMethod(){
		int i=0;
		try{
			i=i/0;
		}catch(Exception e){
			//记录日志，级别为SEVERE，信息为”除以0“
			logger.log(Level.SEVERE,"除以0");
			System.out.println("程序结束");
		}
	}
}