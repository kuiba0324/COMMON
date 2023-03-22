package COMMON.NinthPackage;

import java.util.Iterator;

//֧��foreachѭ�h�������Զ��弯����
/*
 * �����Զ���ļ����࣬Ҫ��֧��foreachѭ�����������밴�ձ�׼ʵ��Iterable�ӿں�Iterator�ӿ�
 * */
public class Class9 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//����ѧ��������
		Students students = new Students(10);
		//ͨ��foreach���ѭ������ѧ���������ÿ��Ԫ��
		for(Object obj:students){
			Student stu = (Student)obj;
			System.out.println(stu.toString());
		}
	}

}

//֧��foreachѭ��������ѧ��������
class Students implements Iterable{
	private Student[] stus;
	
	//�ù��캯����������ָ����С��ѧ����������飬����ʼ��
	public Students(int size){
		stus =  new Student[size];
		for(int i = 0;i < size ;i++){
			stus[i] = new Student(String.valueOf(i),"ѧ��"+String.valueOf(i));
		}
	}
	//ʵ��iterator�ӿڵ���Ҫ����,�����Զ���ĵ��������
	@Override
	public Iterator iterator() {
		return new StudentIterator();
	}
	
	private class StudentIterator implements Iterator{
		//��ǰ����Ԫ�ص��±�
		private int index = 0;
		
		
		//�ж��Ƿ�����һ��Ԫ��
		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return index != stus.length;
		}
		//���ص�ǰԪ�����ݣ��������±�
		@Override
		public Object next() {
			// TODO Auto-generated method stub
			return stus[index++];
		}
		
		
	}
	
}

class Student {
	String A = "";
	String B = "";
	public Student(String A,String B){
		this.A = A;
		this.B = B;
		
	}
	
	@Override
	public String toString(){
		return A+":"+B;
		
	}
}
