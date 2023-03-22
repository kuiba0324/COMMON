package COMMON.SeventhPackage;
//同步i队列

public class Class7 {
	public static void main(String[] args){
		System.out.println("程序开始");
		//生成同步队列
		SynchronizedQuery synQuery = new SynchronizedQuery();
		//生成写入线程
		WriteThread writeThread = new WriteThread(synQuery);
		//生成读取线程
		ReadThread readThread = new ReadThread(synQuery);
		//启动两个线程
		readThread.start();
		writeThread.start();
		
		
		
	}
}
