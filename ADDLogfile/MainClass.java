package COMMON.ADDLogfile;

import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("����ʼ");
		LoggingClass log1 = new LoggingClass();
		log1.badMethod();
	}

}
class LoggingClass{
	//������־��¼����
	Logger logger;
	LoggingClass(){
		try{
			//��ָ���ļ�   true��ʾ����׷��
			FileHandler fh = new FileHandler("info.log",true);	//�ù��캯��Ĭ��ָ���ĵ�ַ������
			//���ù�������getLogger���logger����logger��������LoggingClass
			//logger = Logger.getLogger("LoggingClass");			//COMMON.ADDLogfile.LoggingClass badMethod
			//logger = Logger.getLogger("");	//java.util.logging.LogManager$RootLogger log
			/*
			 * ���Ǵ���һ��rootLogger����ʹû����ʾ����Ҳ�Ǵ��ڵģ�����Ĭ���������ΪDEBUG
			 * ����������Logger��Ĭ�ϼ̳���rootLogger 
			 * 2 �Զ����Logger����Loggger���̳���rootLogger
			 * ��ʽ���£� [quote]log4j.logger.A.B.C[/quote]
			 * �����������ʵ������3��loggerʵ�������Ƿֱ���"A"��"A.B"��"A.B.C"��ÿ��������ϵͳ��ȡ��loggerʱ��
			 * �������½�ʵ������Щʵ����ϵͳ������ʱ��Ͱ��������ļ���ʼ���õģ�Ҳ����ʱ��һ�����õ�ʱ�����ģ�Ȼ�󻺴���ʵ�����Ժ�ʹ�ã�
			 * �ⲿ�ֻ�û��ʱ���о�����
			 * 
			 */
			//logger = Logger.getLogger("w");	//COMMON.ADDLogfile.LoggingClass badMethod
			logger = Logger.getLogger(" ");		//COMMON.ADDLogfile.LoggingClass badMethod
			//���һ����־�������Լ�¼��־��Ϣ
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
			//��¼��־������ΪSEVERE����ϢΪ������0��
			logger.log(Level.SEVERE,"����0");
			System.out.println("�������");
		}
	}
}