package COMMON.Method_getResource;

import java.net.URL;

public class Demo {

	public static void main(String[] args) {
		System.out.println("����ʼ");
		// TODO Auto-generated method stub
		Demo demo= new Demo();
		demo.display();
	}
	private void display() {
        String path = this.getClass().getResource(".").getPath();	//��ǰĿ¼
        System.out.println(path);
        path=this.getClass().getResource("./demo.txt").getPath();	///E:/Myeclipseworkplace/CommonProject/bin/COMMON/Method_getResource/
        System.out.println(path);
        path=this.getClass().getResource("").getPath();	//��ǰĿ¼
        System.out.println(path);
        path=this.getClass().getResource("/").getPath();	//binĿ¼/class��Ŀ¼
        System.out.println(path);
        URL url=this.getClass().getResource("demo/demo.txt");
        System.out.println(url);       
        path=Demo.class.getClassLoader().getResource("").getPath();	//�����������·��
        System.out.println(path);		   
        path=Thread.currentThread().getContextClassLoader().getResource("").getPath();
        System.out.println(path);
        path=Thread.currentThread().getContextClassLoader().getResource("./COMMON/Method_getResource/demo.txt").getPath();
        System.out.println(path);
        
    }

}
