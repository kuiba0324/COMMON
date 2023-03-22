package COMMON.SixthPackage;

public class RandomArray {
	//保存随机数的数组
	private int[][] array;
	//设置数组维度的大小
	private int size;
	//数组的读取函数
	public int[][] getArray(){
		return array;
	}
	//该构造函数对数组的维度大小进行初始化，并生成随机数组
	public RandomArray(int size){
		setSize(size);
		array = new int[size][size];
		generateRandomArray();
	}
	//数组大小的设置函数
	public void setSize(int size){
		this.size = size;
	}
	//生成具有不重复随机数的数组
	private void generateRandomArray(){
		//临时随机数变量
		int randomNumber;
		//判断是否重复的标记变量
		boolean isRepeated;
		//循环所有数组元素
		for(int i = 0;i < size;i++){
			for(int j = 0;j<size;j++){
				//生成1到size*size之间的一个随机数
				randomNumber = (int)(Math.random()*size*size)+1;
				//检查该随机数是否重复
				isRepeated = false;
				for(int x = 0;x<size;x++ ){
					for(int y=0;y<size;y++){
						if(randomNumber == array[x][y]){
							isRepeated = true;
							break;
							
						}
					}
				}
				
				//如果没有重复，则给相应的数组元素赋值,否则，重置当前数组元素下标，，留待下次循环在次设置随机数
				if(!isRepeated){
					array[i][j] = randomNumber;
					
				}else{
					j--;
				}
			}
		}
	}
	
}
