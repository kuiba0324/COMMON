package COMMON.FirstProject;
//类反射，获取类的元数据信息
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.sql.Timestamp;
import java.util.Calendar;

public class Project_First {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Calendar birthday = Calendar.getInstance();
		birthday.set(1999, 3, 24, 0, 0,0);
		Student s = new Student("00008","佳明",true,new Timestamp(birthday.getTimeInMillis()),1.80);
		ClassInfo classInfo = new ClassInfo();
		System.out.println(classInfo.getClassInfo(s));
		
		
		System.out.println("没毛病");
	}

}

class ClassInfo{
	public String getClassInfo(Object obj){
		StringBuffer result = new StringBuffer();
		//得到obj的class引用变量
		Class cls = obj.getClass();
		//得到obj的属性信息
		Field[] fields = cls.getDeclaredFields();
		//得到obj的完整类名，包含相应报名
		String fullName = cls.getName();
		//得到去除包名称的类名
		String className =  fullName.substring(fullName.lastIndexOf('.')+1);
		//如果包有定义，获得相应包的名称
		int packagePosition = fullName.lastIndexOf('.');
		String packageName = null;
		if(packagePosition < 0){
			packageName = "";
		}else{
			packageName = fullName.substring(0,fullName.lastIndexOf('.'));
		}
		
		//输出包名和类名
		result.append("包的名称为："+packageName+"\n");
		result.append("类的名称为："+className+"\n");
		//输出类中的所有属性信息
		for(Field field : fields){
			//允许访问私有成员？
			//https://www.cnblogs.com/sunxucool/p/3552985.html
			field.setAccessible(true);
			
			try{
				//输出私有属性信息
				if(field.getModifiers() == Modifier.PRIVATE){
					result.append("私有属性"+field.getName()+":值为"+field.get(obj)+"\n");
				}
				
				if(field.getModifiers() == Modifier.PROTECTED){
					result.append("受保护属性"+field.getName()+":值为"+field.getByte(obj)+"\n");
				}
			}catch(Exception e){
				System.out.println(e.getMessage());
			}
		}
		return result.toString();
	}
	
}
 class Student {
	 String number = null;
	String name = null;
	Boolean sex = false;
	Timestamp birthday = null;
	double height = 0;
	
	public Student(){
		
	}
	public Student(String number,String name,Boolean sex,Timestamp birthday,double height){
		this.number = number;
		this.name = name;
		this.sex = sex;
		this.birthday= birthday;
		this.height = height;
		
	}
	
	public String toString(){
		return "学生";
	}
}
