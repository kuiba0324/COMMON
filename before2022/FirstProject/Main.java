package COMMON.FirstProject;

import java.lang.reflect.Field;

class AccessibleTest {  
    
    private int id;  
    private int name;  
    
 
    public AccessibleTest() {  
  
    }  
  
    public int getId() {  
        return id;  
    }  
  
    public void setId(int id) {  
        this.id = id;  
    }  
  
    public int getName() {  
        return name;  
    }  
  
    public void setName(int name) {  
        this.name = name;  
    }  
  
}
public class Main {  
    
    public static void main(String[] args) throws Exception {  
        Class clazz = Class.forName("COMMON.FirstProject.AccessibleTest");  
        AccessibleTest at = new AccessibleTest();  
        at.setId(1);  
        at.setName(2);  
        for (Field f : clazz.getDeclaredFields()) {  
            f.setAccessible(true);//AccessibleTest���еĳ�Ա����Ϊprivate,�ʱ�����д˲���  
            System.out.println(f.get(at));//��ȡ��ǰ�����е�ǰField��value  sss
            f.set(at,4);
            System.out.println(at.getId());
        }  
  
    }  
  
}