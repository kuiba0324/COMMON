package COMMON.NinthPackage;

import java.util.Iterator;

//支持foreach循環迭代的自定义集合类
/*
 * 对于自定义的集合类，要想支持foreach循环迭代，必须按照标准实现Iterable接口和Iterator接口
 * */
public class Class9 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//创建学生集合类
		Students students = new Students(10);
		//通过foreach语句循环迭代学生集合类的每个元素
		for(Object obj:students){
			Student stu = (Student)obj;
			System.out.println(stu.toString());
		}
	}

}

//支持foreach循环迭代的学生集合类
class Students implements Iterable{
	private Student[] stus;
	
	//该构造函数可以生成指定大小的学生类变量数组，并初始化
	public Students(int size){
		stus =  new Student[size];
		for(int i = 0;i < size ;i++){
			stus[i] = new Student(String.valueOf(i),"学生"+String.valueOf(i));
		}
	}
	//实现iterator接口的重要方法,返回自定义的迭代类变量
	@Override
	public Iterator iterator() {
		return new StudentIterator();
	}
	
	private class StudentIterator implements Iterator{
		//当前迭代元素的下标
		private int index = 0;
		
		
		//判断是否有下一个元素
		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return index != stus.length;
		}
		//返回当前元素数据，并递增下标
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
