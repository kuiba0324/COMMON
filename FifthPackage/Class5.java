package COMMON.FifthPackage;

import java.lang.reflect.Array;
import java.util.Arrays;

//ͨ�����Ʋ�����һ��������ʵ�ֶ�̬��������Ĵ�С
/*
 * 
 * */
public class Class5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//int[] beginArray = new int[10];	//��ʼ���������ָ������ĳ�ʼֵ���ڷ����ڴ�
		int[] beginArray = {23,43,54,67,34,543,42,6,57,634,235,4654,45};
		Arrays.sort(beginArray);	//����������
		System.out.println("ԭʼ����Ϊ��"+beginArray.length);
		
		//��̬��������һֱ����������һ��������
		Object newArray_embryonic = Array.newInstance(beginArray.getClass().getComponentType(), Array.getLength(beginArray)*2);
		//��������Ԫ��
		System.arraycopy(beginArray,0,newArray_embryonic,0,Array.getLength(beginArray));
		//ת����������
		int[] newArray = (int[])newArray_embryonic;
		for(int i=0;i<newArray.length;i++)
			System.out.println(newArray[i]);
		
		

	}

}
