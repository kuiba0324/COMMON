package COMMON.SeventhPackage;
//ͬ��i����

public class Class7 {
	public static void main(String[] args){
		System.out.println("����ʼ");
		//����ͬ������
		SynchronizedQuery synQuery = new SynchronizedQuery();
		//����д���߳�
		WriteThread writeThread = new WriteThread(synQuery);
		//���ɶ�ȡ�߳�
		ReadThread readThread = new ReadThread(synQuery);
		//���������߳�
		readThread.start();
		writeThread.start();
		
		
		
	}
}
