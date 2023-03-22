package COMMON.FifthPackage;

import java.lang.reflect.Array;
import java.util.Arrays;

//通过复制并创建一个新数组实现动态调整数组的大小
/*
 * 
 * */
public class Class5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//int[] beginArray = new int[10];	//初始化对象必须指明对象的初始值便于分配内存
		int[] beginArray = {23,43,54,67,34,543,42,6,57,634,235,4654,45};
		Arrays.sort(beginArray);	//对数组排序
		System.out.println("原始长度为："+beginArray.length);
		
		//动态创建类型一直，长度增加一倍的数组
		Object newArray_embryonic = Array.newInstance(beginArray.getClass().getComponentType(), Array.getLength(beginArray)*2);
		//复制数组元素
		System.arraycopy(beginArray,0,newArray_embryonic,0,Array.getLength(beginArray));
		//转换数组类型
		int[] newArray = (int[])newArray_embryonic;
		for(int i=0;i<newArray.length;i++)
			System.out.println(newArray[i]);
		
		

	}

}
