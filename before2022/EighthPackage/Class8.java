package COMMON.EighthPackage;

import java.util.Scanner;

//Ӧ���ַ����������

public class Class8 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// ���ַ����������ַ���
		System.out.println("�������ַ���");
		System.out.println(ConsoleInput.readString());

		// ���ַ�������������
		System.out.println("����������");
		System.out.println(ConsoleInput.readInt());
		
		//����ֱ�Ӳ���java1.5�_ʼ֧�ֵ�Scanner
//		Scanner s = new Scanner(System.in);
//		System.out.println(s.next());
	}  
}

// �ܹ����ַ��������벻ͬ�������ݵ���
class ConsoleInput {
	// �þ�̬�����������ַ����������ַ���
	public static String readString() {
		String result = null;
		try {
			
			byte[] bytes = null;
			//for (int j = 0;j<20;j++) {
				// ����System.in.read�����ַ���Ϣ���ֽ�������
				bytes = new byte[1000];
				System.in.read(bytes);
				/*
				 * �Զ����ƣ����� 2���޷���������ʽ����һ�������������ַ�����ʾ��ʽ�� �������Ϊ�������޷�������ֵΪ��������
				 * 232��������ڸò����� ����ֵת��Ϊ�����ƣ����� 2����ʽ����ǰ�� 0 �� ASCII �����ַ�����
				 */
				for (int i = 0; i < 10; i++) {
					int by = bytes[i];
					if (by < 0) {
						by = by * -1;
					}
					//System.out.println(by);
					System.out.println(Integer.toBinaryString(by));

				}

			//}
			
			// ͨ��ʹ��ƽ̨��Ĭ���ַ�������ָ���� byte ���飬����һ���µ� String�� ȥ��β�������ÿո�
			/*
			 * �����ַ����ĸ���������ǰ���հ׺�β���հס�
			 * ����� String �����ʾһ�����ַ����У����ߴ� String �����ʾ���ַ����еĵ�һ�������һ���ַ��Ĵ��붼���� '\u0020'���ո��ַ������򷵻ضԴ� String ��������á�
			 * �������ַ�����û�д������ '\u0020' ���ַ����򴴽�������һ����ʾ���ַ������� String ����
			 * ���򣬼ٶ� k Ϊ�ַ����д������ '\u0020' �ĵ�һ���ַ���������m Ϊ�ַ����д������ '\u0020' �����һ���ַ�����������
			 * ��һ���µ� String ��������ʾ���ַ����д����� k �����ַ���ʼ�������� m �����ַ����������ַ������� this.substring(k, m+1) �Ľ����
			 * 
			 * �˷��������ڽ�ȥ�ַ�����ͷ��ĩβ�Ŀհף�����������
			 * */
			result = new String(bytes).trim();

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return result;
	}

	// �þ�̬���������ַ�������������
	public static int readInt() {
		int result = 0;
		try {
			// ����System.in.read�����ַ���Ϣ���ֽ�������
			byte[] bytes = new byte[1000];
			System.in.read(bytes);
			String str = new String(bytes).trim();

			// ���ַ���ת��Ϊ����
			result = Integer.parseInt(str);
		} catch (Exception e) {

		}

		return result;
	}

}