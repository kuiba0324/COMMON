package COMMON.TenthPackage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

//֧�ּ���Ԫ���������

public class Class10 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			Student stu1 = new Student("000002","����");
			Student stu2 = new Student("000001","����");
			Student stu3 = new Student("000003","�������");
			//������Student��ӵ�ArrayList����
			ArrayList stuList = new ArrayList();
			stuList.add(stu1);
			stuList.add(stu2);
			stuList.add(stu3);
			
			//��ArrayList��������
			Collections.sort(stuList);
			
			//������ʾÿ��ArrayList���ϵ�Ԫ��
			Iterator it = stuList.iterator();
			while(it.hasNext()){
				
				System.out.println("ѧ����ϢΪ"+((Student)it.next()).toString());
			}
	}

}


//�̳�comparable�ӿ���֧�ָ��಻ͬ�����ıȽϲ���
class Student implements Comparable{
	//ѧ��
	private String sid;
	//����
	private String Name;
	public Student(){
		
	}
	public Student(String sid ,String name){
		this.sid = sid;
		this.Name = name;
	}
	@Override
	public int compareTo(Object element) {
		// TODO Auto-generated method stub
		Student s = (Student)element;
		return this.sid.compareTo(s.sid);
	}
	//��ʽ���ַ���Ϣ���
	public String toString(){
		return this.sid + "��" + this.Name;
	}
	
}