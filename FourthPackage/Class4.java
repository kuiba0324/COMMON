package COMMON.FourthPackage;
//��������ʾ��ʹ��String���ṩ��split����ʵ�ּ򵥵ķִʴ�����Ӧ�����������������ҳ�ı����зִʽ����ȣ�

public class Class4 {
	public static void main(String[] args){
		System.out.println("����ʼ");
		//����ͣ�ôʱ�
		String[] stopList = {
				"and" ,"is" ,"an" ,"are" ,"at",
				"be" ,"by" ,"will"
		};
		//��Ҫ���зִʴ�������
		String doc = "what are you fucking doing?";
		//Ϊ��ȷ���ܹ���ȷ����ͣ�ôʣ������ͣ�ô������������
		java.util.Arrays.sort(stopList);
		//�����κηǵ����ַ����зִ�
		/*
		 * �÷�����ƥ��ִʽ��޵�ʱ����Ȼ����������ʽ
		 */
		String[] results = doc.toLowerCase().split("\\W");
		
		//��ʾ�ִʽ��
		for(int i = 0;i<results.length;i++){
			//����ʾ���õĿ��ַ�
			if( results[i].equals("")){
				continue;
			}
			
			//����ʾͣ�ô�
			if(java.util.Arrays.binarySearch(stopList, results[i] ) < 0){
				System.out.println(results[i]);
			}
		}
		
	
	}
}
