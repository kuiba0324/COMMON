package COMMON.TenthPackage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

//支持集合元素排序的类

public class Class10 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			Student stu1 = new Student("000002","魁拔");
			Student stu2 = new Student("000001","镇魂街");
			Student stu3 = new Student("000003","你的名字");
			//将三个Student添加到ArrayList集合
			ArrayList stuList = new ArrayList();
			stuList.add(stu1);
			stuList.add(stu2);
			stuList.add(stu3);
			
			//对ArrayList集合排序
			Collections.sort(stuList);
			
			//迭代显示每个ArrayList集合的元素
			Iterator it = stuList.iterator();
			while(it.hasNext()){
				
				System.out.println("学生信息为"+((Student)it.next()).toString());
			}
	}

}


//继承comparable接口以支持该类不同变量的比较操作
class Student implements Comparable{
	//学号
	private String sid;
	//姓名
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
	//格式化字符信息输出
	public String toString(){
		return this.sid + "：" + this.Name;
	}
	
}