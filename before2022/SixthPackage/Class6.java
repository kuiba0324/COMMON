package COMMON.SixthPackage;
//���ɾ��в��ظ������������
/*
 * �ص�ע��Math.random()			�þ�̬�����������������
 * 
 * */
public class Class6 {
	public static void main(String[] args){
		System.out.println("����ʼ");
		//��������ά�ȵĴ�С
		final int number = 4;
		//���ɾ��в��ظ������������
		RandomArray random = new RandomArray(number);
		//ѭ����ʾ����Ԫ��
		for(int i = 0;i<number;i++){
			for(int j=0;j<number;j++){
				System.out.print(random.getArray()[i][j]+"\t");
			}
			System.out.println();
		}
		System.out.println("�������");
	}
}
