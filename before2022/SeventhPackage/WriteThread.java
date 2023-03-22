package COMMON.SeventhPackage;

import java.util.LinkedList;

class WriteThread extends Thread{
	//ͬ�����������
	private SynchronizedQuery synQuery;
	//�ù��캯����ʼ��ͬ�����������
	public WriteThread (SynchronizedQuery synQuery){
		this.synQuery = synQuery;
		
	}
	//�߳���������
	public void run(){
		//��ͬ����������ַ�������
		synQuery.addElement("��Ԫ��");
	}
}

class ReadThread extends Thread {
	//ͬ�����������
	private SynchronizedQuery synQuery;
	//��ʼ��ͬ����
	public ReadThread(SynchronizedQuery synQuery){
		this.synQuery = synQuery;
	}
	public void run(){
		System.out.println((String)synQuery.popElement());
	}
}

class SynchronizedQuery {
	//�洢Ԫ�ص�linkList
	private LinkedList linkedList = new LinkedList();
	//���Ԫ�ص�ͬ������
	public synchronized void addElement(Object obj){
		
		while(true){
			linkedList.add(obj);
			System.out.println("�����һ��Ԫ��");
			
			/*
			 * 1��wait()��notify/notifyAll() ������Object�ı���final�������޷�����д��
			 * 
			 * 2��wait()ʹ��ǰ�߳�������ǰ���� �����Ȼ������һ�����synchronized�ؼ���ʹ�ã�
			 * ����һ����synchronized ͬ���������ʹ�� wait()��notify/notifyAll() ������ 
			 * 
			 * 3������ wait()��notify/notifyAll() ��synchronized �����ִ�У�˵����ǰ�߳�һ���ǻ�ȡ�����ġ�
			 * ���߳�ִ��wait()����ʱ�򣬻��ͷŵ�ǰ������Ȼ���ó�CPU������ȴ�״̬�� ֻ�е� notify/notifyAll()
			 * ��ִ��ʱ�򣬲Żỽ��һ�����������ڵȴ�״̬���̣߳�Ȼ���������ִ�У�ֱ��ִ����synchronized
			 * �����Ĵ��������;����wait() ���ٴ��ͷ����� Ҳ����˵��notify/notifyAll() ��ִ��ֻ�ǻ��ѳ�
			 * ˯���̣߳������������ͷ����������ͷ�Ҫ�������ľ���ִ������������ڱ���У�������ʹ����notify/
			 * notifyAll() �������˳��ٽ������Ի��������߳�
			 *  
			 * 4��wait() ��Ҫ��trycatch��Χ���ж�Ҳ����ʹwait�ȴ�\���̻߳��ѡ�\
			 * 
			 * 5��notify ��wait��˳���ܴ����A�߳���ִ��notify������B�߳���ִ��wait��������ôB�߳����޷������ѵġ� 
			 * 
			 * 6��notify �� notifyAll������notify����ֻ����һ���ȴ�������ģ��̲߳�ʹ���߳̿�ʼִ�С���������ж���̵߳ȴ�һ������
			 * �������ֻ�ỽ������һ���̣߳�ѡ���ĸ��߳�ȡ���ڲ���ϵͳ�Զ��̹߳����ʵ�֡�notifyAll�ỽ�����еȴ�(�����)�̣߳�
			 * ������һ���߳̽����һ������ȡ���ڲ���ϵͳ��ʵ�֡������ǰ������ж���߳���Ҫ������,�Ƽ�ʹ��notifyAll
			 * ������������������-�����������ʹ�ã�ÿ�ζ���Ҫ�������е������߻��������ߣ����жϳ����Ƿ���Լ�������ִ�С�
			 * 
			 * 7���ڶ��߳���Ҫ����ĳ�������ı仯��ʹ��if ����while?Ҫע�⣬notify���ѳ�˯���̺߳��̻߳�����ϴε�ִ�м�������ִ�С�
			 * �����ڽ��������ж�ʱ�򣬿����Ȱ� wait�����Բ��������п��ǣ���Ȼ��Ҫȷ������һ��Ҫִ�У�����Ҫ��֤����ֱ������һ����
			 * ������ִ�У�Ҫʹ��while��ִ�У���ȷ�����������һ��ִ�С�
			 */
			
			// ���������߳�
			notify();
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	//ȥ��Ԫ�ص�ͬ������
	public synchronized Object popElement(){
		for(int i = 0;i<20;i++){
			while(linkedList.isEmpty()) {
				try {
					wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			linkedList.removeLast();
			System.out.println("��ȡ������һ��Ԫ��");
			notify();
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		return linkedList.removeLast();
	}
			
}
