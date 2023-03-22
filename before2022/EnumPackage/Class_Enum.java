package COMMON.EnumPackage;
//关于枚举

public class Class_Enum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("程序开始");
	}

}

enum Size {
	SMALL("小", 1), MEDIUM("中", 2), BIG("大", 3);
	private String size;
	private int id;

	private Size(String size, int id) {
		this.size = size;
		this.id = id;

	}

	public int getId() {
		return id;

	}

	public String getSize(){
		return size;
		
	}

	public static Size getSizeBySomeThing(String size){
		for(Size result :Size.values()){
			if(result.getSize() == size){
				return result;
			}
		}
		return null;
	}
}