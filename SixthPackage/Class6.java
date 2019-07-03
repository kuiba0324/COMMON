package COMMON.SixthPackage;
//生成具有不重复随机数的数组
/*
 * 重点注意Math.random()			该静态方法用于生成随机数
 * 
 * */
public class Class6 {
	public static void main(String[] args){
		System.out.println("程序开始");
		//定义数组维度的大小
		final int number = 4;
		//生成具有不重复随机数的数组
		RandomArray random = new RandomArray(number);
		//循环显示数组元素
		for(int i = 0;i<number;i++){
			for(int j=0;j<number;j++){
				System.out.print(random.getArray()[i][j]+"\t");
			}
			System.out.println();
		}
		System.out.println("程序结束");
	}
}
