package COMMON.SecondProject;
//�ַ���֤������������ʽ�����ض���ʽ�ı����ȷ�˵���£����ԭʼ�ı��Ƿ�Ϊ�Ϸ�http��ַ


import java.util.regex.Pattern;
public class Project_Second {
	public static void main(String[] args){
		System.out.println("����ʼ");
		Pattern pattern = Pattern.compile("http(s)?://([\\w-]+\\.)+[ \\w-]+(/[\\w- ./?%&=]*)?");
		//Ҫ������ԭʼ�ı�
		String str  = "http://www.njmars.net";
		
		//�ж��Ƿ���ƥ��
		boolean result = pattern.matcher(str).matches();
		
		//��ʾƥ����
		if(result){
			System.out.println(str + "����Ч��http��ַ");
		}else{
			System.out.println(str+"������Ч��http��ַ");
		}
	}
}
