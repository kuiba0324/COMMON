package COMMON.ThirdPackage;
//��������ʾ��ʹ�������ʽ��MaskFormatter��֤�Լ������ı���������Ϣ�ķ��������ı���ֻ��������8�������ַ�
/*
 * 	#	�κ���Ч����
 * 	'	ת���ַ������ڱܿ��κ�������������ַ�
 * 	U	�κ��ַ�����Сд�ַ�ӳ��Ϊ��д
 * 	L	�κ��ַ�������дӳ��ΪСд
 * 	A	�κ��ַ�������
 * 	?	�κ��ַ�
 * 	*	�����ַ�
 * 	H	�κ�ʮ�������ַ���0-9��a-z��A-Z��
 * */


import java.awt.FlowLayout;
import java.awt.Point;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

public class Window extends JFrame{
	JTextField jtf = null;
	//�����ʽ��
	MaskFormatter format  = null;
	//Class3 cl3 = new Class3();
	public Window(){
		super("�ı���");
		this.DO();
		this.setLocation(new Point(800,400));
		this.setSize(300, 100);
		this.setAlwaysOnTop(isAlwaysOnTop());
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE); //���ùرշ�ʽ ��������õĻ� �ƺ��رմ���֮�󲻻��˳�����
	}
	public void DO(){
		System.out.println("DO������ʼ");
	
		//���������ʽ�����
		try{
			format = new MaskFormatter("########");
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		jtf = new JFormattedTextField(format);
		jtf.setColumns(8);
		this.setLayout(new FlowLayout());
		this.add(jtf);
		
		System.out.println("DO��������");
	}
}
