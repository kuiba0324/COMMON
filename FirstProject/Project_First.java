package COMMON.FirstProject;
//�෴�䣬��ȡ���Ԫ������Ϣ
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.sql.Timestamp;
import java.util.Calendar;

public class Project_First {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Calendar birthday = Calendar.getInstance();
		birthday.set(1999, 3, 24, 0, 0,0);
		Student s = new Student("00008","����",true,new Timestamp(birthday.getTimeInMillis()),1.80);
		ClassInfo classInfo = new ClassInfo();
		System.out.println(classInfo.getClassInfo(s));
		
		
		System.out.println("ûë��");
	}

}

class ClassInfo{
	public String getClassInfo(Object obj){
		StringBuffer result = new StringBuffer();
		//�õ�obj��class���ñ���
		Class cls = obj.getClass();
		//�õ�obj��������Ϣ
		Field[] fields = cls.getDeclaredFields();
		//�õ�obj������������������Ӧ����
		String fullName = cls.getName();
		//�õ�ȥ�������Ƶ�����
		String className =  fullName.substring(fullName.lastIndexOf('.')+1);
		//������ж��壬�����Ӧ��������
		int packagePosition = fullName.lastIndexOf('.');
		String packageName = null;
		if(packagePosition < 0){
			packageName = "";
		}else{
			packageName = fullName.substring(0,fullName.lastIndexOf('.'));
		}
		
		//�������������
		result.append("��������Ϊ��"+packageName+"\n");
		result.append("�������Ϊ��"+className+"\n");
		//������е�����������Ϣ
		for(Field field : fields){
			//�������˽�г�Ա��
			//https://www.cnblogs.com/sunxucool/p/3552985.html
			field.setAccessible(true);
			
			try{
				//���˽��������Ϣ
				if(field.getModifiers() == Modifier.PRIVATE){
					result.append("˽������"+field.getName()+":ֵΪ"+field.get(obj)+"\n");
				}
				
				if(field.getModifiers() == Modifier.PROTECTED){
					result.append("�ܱ�������"+field.getName()+":ֵΪ"+field.getByte(obj)+"\n");
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
		return "ѧ��";
	}
}
